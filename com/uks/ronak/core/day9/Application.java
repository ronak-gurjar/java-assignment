package com.uks.ronak.core.day9;

import java.io.*;
import java.util.*;

import static java.lang.System.*;

public class Application extends Thread {

    HashMap<String, EmpInfo> mergeData = new HashMap<>();
    ArrayList<EmpInfo> userInfo = new ArrayList<>();
    ArrayList<EmpInfo> userLogInInfo = new ArrayList<>();

    String mode;

    Application(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    /*------------------------loader process-------------------------*/

    // this method read userInfo file and store data in UserInfoData
    //   public synchronized void fileRead(String filepath, String filePath2) {
    public void fileRead(String filepath, String filepath2) {

        File userInfoFile = new File(filepath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(userInfoFile);
        } catch (FileNotFoundException e) {
            out.println("file not found");
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] userInfoToken = data.split(",");
                EmpInfo userInfoData = new EmpInfo(Integer.parseInt(userInfoToken[0]), userInfoToken[1],
                        userInfoToken[2], userInfoToken[3], userInfoToken[4],
                        Long.parseLong(userInfoToken[5]), Long.parseLong(userInfoToken[6]), null);
                // userid store as a key and userInfoData store as a value
                mergeData.put(userInfoToken[0], userInfoData);
                // all employee data add in arraylist for printing information
                userInfo.add(userInfoData);
            }
        }
        // this function read userLogInInfo file
        userLogInInfoRead(filepath2, mergeData);
    }

    // this method read userLogInInfo file and only put userid and userRole in mergeData
    public void userLogInInfoRead(String filepath2, HashMap<String, EmpInfo> mergeData) {
        String data;
        String[] userLogInInfoToken;
        File userLogInInfoFile = new File(filepath2);
        Scanner scanner = null;
        try {
            scanner = new Scanner(userLogInInfoFile);
        } catch (FileNotFoundException e) {
            out.println("file not found");
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                userLogInInfoToken = data.split(",");
                // store userid in mergeData as a key
                EmpInfo empInfo = new EmpInfo(Integer.parseInt(userLogInInfoToken[0]),
                        userLogInInfoToken[1], userLogInInfoToken[2], userLogInInfoToken[3]);
                EmpInfo uRole = mergeData.get(userLogInInfoToken[0]);
                uRole.setUserRole(userLogInInfoToken[3]);
                /* merge data have already 6 key and 6 emp information if new key  is equal to old key
                 then hash map not put new key and hashmap put userRole at old key,hashmap allowed only  unique kay*/
                mergeData.put(userLogInInfoToken[0], uRole);
                // all employee log in information add in arraylist for printing information
                userLogInInfo.add(empInfo);
            }
        }
    }

    // this method merge both file in one object and that object write in file
    public void mergeFileWrite(String filepath) throws IOException, ClassNotFoundException {
        File mergeFile = new File(filepath);
        // serialization
        FileOutputStream fous = new FileOutputStream(mergeFile);
        ObjectOutputStream oos = new ObjectOutputStream(fous);
        oos.writeObject(mergeData);
        fous.close();
        oos.close();

        // deserialization
        FileInputStream fin = new FileInputStream(mergeFile);
        ObjectInputStream oin = new ObjectInputStream(fin);
        oin.readObject();
        oin.close();
        fin.close();

    }

    public void display() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        /* user cam only enter three time userName and password if three time both is wrong system get
         close automatically */
        for (int i = 0; i < 3; i++) {
            System.out.println("enter username");
            String uName = scanner.nextLine();
            System.out.println("enter password");
            String password = scanner.nextLine();

            /*------------------------authentication  process-------------------------*/

            for (int j = 0; j < mergeData.size(); j++) {
                // validate userName and password
                if (uName.equals(userLogInInfo.get(j).userName) && password.equals(userLogInInfo.get(j).password)) {
                    // print logged in user information
                    out.println("logged in user information");
                    printUserInfo(j);
                    // admin can view and search all person details -> employee,admin and manager
                    if (userLogInInfo.get(j).userRole.equalsIgnoreCase("admin")) {
                        out.println("press [L] for show record");
                        out.println("press [S] for search record");
                        out.println("press [5] for  exit ");
                        while (true) {
                            out.println("enter choice");
                            String choice = scanner.nextLine();
                            switch (choice) {
                                case "L":

                                    /*------------------------display information  process-------------------------*/

                                    out.println("press [E] for employee");
                                    out.println("press [M] for manager ");
                                    out.println("press [A] for admin ");
                                    out.println("press [ALL] for all ");
                                    out.println("press [5] for  exit ");
                                    while (true) {
                                        out.println("enter choice");
                                        String choice2 = scanner.nextLine();
                                        switch (choice2) {
                                            case "E":
                                                out.println("all employee information");
                                                for (int k = 0; k < userLogInInfo.size(); k++) {
                                                    if (userLogInInfo.get(k).userRole.equalsIgnoreCase("employee")) {
                                                        printUserInfo(k);
                                                    }
                                                }
                                                break;
                                            case "M":
                                                out.println("all manager information");
                                                for (int k = 0; k < userLogInInfo.size(); k++) {
                                                    if (userLogInInfo.get(k).userRole.equalsIgnoreCase("manager")) {
                                                        printUserInfo(k);
                                                    }
                                                }
                                                break;
                                            case "A":
                                                out.println("all admin information");
                                                for (int k = 0; k < userLogInInfo.size(); k++) {
                                                    if (userLogInInfo.get(k).userRole.equalsIgnoreCase("admin")) {
                                                        printUserInfo(k);
                                                    }
                                                }
                                                break;
                                            case "ALL":
                                                printMergeData();
                                                break;
                                            case "5":
                                                System.exit(0);
                                                break;
                                            default:
                                                out.println("oops...wrong choice");
                                        }
                                    }
                                case "S":

                                    /*------------------------finder process-------------------------*/

                                    out.println("press [E] for employee");
                                    out.println("press [M] for manager ");
                                    out.println("press [A] for admin ");
                                    out.println("press [ALL] for all ");
                                    out.println("press [5] for  exit ");
                                    while (true) {
                                        out.println("enter choice");
                                        String choice3 = scanner.nextLine();
                                        switch (choice3) {
                                            case "E":
                                                out.println("enter the name of employee for search");
                                                String eName = scanner.nextLine();
                                                for (int k = 0; k < userInfo.size(); k++) {
                                                    if (userLogInInfo.get(k).userRole.equalsIgnoreCase("employee") && userInfo.get(k).firstName.equalsIgnoreCase(eName)) {
                                                        out.println(eName + "'s information");
                                                        printUserInfo(k);
                                                        flag = false;
                                                    }
                                                }
                                                if (flag) {
                                                    out.println(eName + " not found in employee list");
                                                }
                                                break;
                                            case "M":
                                                out.println("enter the name of manager for search");
                                                String mName = scanner.nextLine();
                                                for (int k = 0; k < userInfo.size(); k++) {
                                                    if (userLogInInfo.get(k).userRole.equalsIgnoreCase("manager") && userInfo.get(k).firstName.equalsIgnoreCase(mName)) {
                                                        out.println(mName + "'s information");
                                                        printUserInfo(k);
                                                        flag = false;
                                                    }
                                                }
                                                if (flag) {
                                                    out.println(mName + " not found in manager list");
                                                }
                                                break;
                                            case "A":
                                                out.println("enter the name of admin for search");
                                                String aName = scanner.nextLine();
                                                for (int k = 0; k < userInfo.size(); k++) {
                                                    if (userLogInInfo.get(k).userRole.equalsIgnoreCase("admin") && userInfo.get(k).firstName.equalsIgnoreCase(aName)) {
                                                        out.println(aName + "'s information");
                                                        printUserInfo(k);
                                                        flag = false;
                                                    }
                                                }
                                                if (flag) {
                                                    out.println(aName + " not found in admin list");
                                                }
                                                break;
                                            case "ALL":
                                                out.println("enter the name  for search");
                                                String name = scanner.nextLine();
                                                for (int k = 0; k < userInfo.size(); k++) {
                                                    if (userInfo.get(k).firstName.equalsIgnoreCase(name)) {
                                                        out.println(name + "'s information");
                                                        printUserInfo(k);
                                                        flag = false;
                                                    }
                                                }
                                                if (flag) {
                                                    out.println(name + " not found in all list");
                                                }
                                                break;
                                            case "5":
                                                System.exit(0);
                                                break;
                                            default:
                                                out.println("oops...wrong choice");
                                        }

                                    }
                                case "5":
                                    System.exit(0);
                                default:
                                    out.println("oops...wrong choice");
                            }
                        }
                        // manager can view and search only employee details
                    } else if (userLogInInfo.get(j).userRole.equalsIgnoreCase("manager")) {
                        out.println("press [L] for show employee record");
                        out.println("press [S] for search employee record");
                        while (true) {
                            out.println("enter choice");
                            String choice3 = scanner.nextLine();
                            switch (choice3) {
                                case "L":
                                    for (int k = 0; k < userLogInInfo.size(); k++) {
                                        if (userLogInInfo.get(k).userRole.equalsIgnoreCase("employee")) {
                                            printUserInfo(k);
                                        }
                                    }
                                    break;
                                case "S":
                                    out.println("enter the name of employee for search");
                                    String name = scanner.nextLine();
                                    for (int k = 0; k < userInfo.size(); k++) {
                                        if (userLogInInfo.get(k).userRole.equalsIgnoreCase("employee") && userInfo.get(k).firstName.equalsIgnoreCase(name)) {
                                            printUserInfo(k);
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        out.println(name + " not found in employee list");
                                    }
                                    break;
                                default:
                                    out.println("oops...wrong choice");
                            }
                        }
                    }

                    // employee can see only his/her information
                    else if (userLogInInfo.get(j).userRole.equalsIgnoreCase("employee")) {
                        System.exit(0);
                    }
                    flag = false;
                    break;
                }
            }
            // if userName and password match break the login loop
            if (!flag) {
                break;
            }
            if (flag) {
                System.out.println("either username or password is wrong, please try again...");
            }
        }
        if (flag) {
            System.out.println("system get closed because data you have provide is not valid, please re-confirm it");
            System.exit(0);
        }
    }

    @Override
    public void run() {
        Application loader = new Application("read");
        Application finder = new Application("write");
        if (loader.getMode().equalsIgnoreCase("read")) {
            synchronized (this) {

                fileRead("src/com/uks/ronak/core/day9/UserInfo.txt",
                        "src/com/uks/ronak/core/day9/UserLoginInfo.txt");
                this.notify();
                try {
                    mergeFileWrite("src/com/uks/ronak/core/day9/mergeFile.txt");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        if (finder.getMode().equalsIgnoreCase("write")) {
            synchronized (this) {
                try {
                    this.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();

            }
        }

    }

    // print mergeData file
    public void printMergeData() {
        for (Map.Entry<String, EmpInfo> e : mergeData.entrySet()) {
            System.out.print(e.getKey() + " -> ");
            System.out.print(e.getValue().getUserRole() + " ");
            System.out.print(e.getValue().getFirstName() + " ");
            System.out.print(e.getValue().getLastName() + " ");
            System.out.print(e.getValue().getAddress() + " ");
            System.out.print(e.getValue().getCity() + " ");
            System.out.print(e.getValue().getMobileNumber() + " ");
            System.out.println(e.getValue().getBasicSalary() + " ");
        }
    }

    //print userInformation at specific index
    public void printUserInfo(int index) {
        System.out.print(userInfo.get(index).getUserId() + " -> ");
        System.out.print(userInfo.get(index).getUserRole() + " ");
        System.out.print(userInfo.get(index).getFirstName() + " ");
        System.out.print(userInfo.get(index).getLastName() + " ");
        System.out.print(userInfo.get(index).getAddress() + " ");
        System.out.print(userInfo.get(index).getCity() + " ");
        System.out.print(userInfo.get(index).getBasicSalary() + " ");
        System.out.println(userInfo.get(index).getMobileNumber() + " ");

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Application loader = new Application("read");
        Application finder = new Application("write");
        // thread group
        ThreadGroup tg = new ThreadGroup("parent");
        Thread t1 = new Thread(tg, loader, "one");
        Thread t2 = new Thread(tg, finder, "two");
        t1.start();
        t1.join();
        t2.start();

    }
}