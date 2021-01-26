package com.uks.ronak.core.day9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class DemoApplication {
    Scanner scanner;
    File userInfo = new File("src\\com\\uks\\ronak\\core\\day9\\UserInfo.txt");
    File userLoginInfo = new File("src\\com\\uks\\ronak\\core\\day9\\UserLoginInfo.txt");
    File mergeFile = new File("src\\com\\uks\\ronak\\core\\day9\\mergeFile.txt");
    String[] userInfoArray;
    String[] userLoginArray;
    String[] mergeArray;
    boolean flag = true;
    List<String> userLoginList = new ArrayList<>();
    List<String> mergeList = new ArrayList<>();
    List<String> userInfoList = new ArrayList<>();

    //this method print userInfo details
    public void userInfo() {
        try {
            scanner = new Scanner(userInfo);
            while (scanner.hasNextLine()) {
                userInfoList.add(scanner.nextLine());
            }
            scanner.close();
          //  userInfoArray = userInfoList.toArray(new String[0]);
            for (String userinfo : userInfoList) {
                out.println(userinfo);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public void userLoginInfo() {
        try {
            Scanner scanner = new Scanner(userLoginInfo);
            while (scanner.hasNextLine()) {
                userLoginList.add(scanner.nextLine());
            }
            userLoginArray = userLoginList.toArray(new String[0]);
            for (String userlogin : userLoginArray) {
                out.println(userlogin);
            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    //this method print mergeFile details
    public void mergeFileInfo() {
        try {
            Scanner scanner = new Scanner(mergeFile);
            while (scanner.hasNextLine()) {
                mergeList.add(scanner.nextLine());
            }
            scanner.close();
            mergeArray = mergeList.toArray(new String[0]);
            for (String merge : mergeArray) {
                out.println(merge);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    //this method print userLoginInfo details

    public void display() {
        Scanner scanner1 = new Scanner(System.in);
        try {
            scanner = new Scanner(userInfo);
            while (scanner.hasNextLine()) {
                userInfoList.add(scanner.nextLine());
            }
            scanner.close();
            //  userInfoArray store user information in array form
            userInfoArray = userInfoList.toArray(new String[0]);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(mergeFile);
            while (scanner.hasNextLine()) {
                mergeList.add(scanner.nextLine());
            }
            scanner.close();
            //  mergeArray store all information of user in array form
            mergeArray = mergeList.toArray(new String[0]);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(userLoginInfo);
            while (scanner.hasNextLine()) {
                userLoginList.add(scanner.nextLine());
            }
            scanner.close();
            //  userLoginArray store user login information in array form
            userLoginArray = userLoginList.toArray(new String[0]);
            // you can enter only three time username and password
            for (int p = 0; p < 3; p++) {
                out.println("enter username:");
                String userName = scanner1.nextLine();
                out.println("enter password");
                String password = scanner1.nextLine();

                for (int i = 0; i < userLoginArray.length; i++) {
                    // check the username and password in userLoginInfo file
                    if (userLoginArray[i].contains(userName) && userLoginArray[i].contains(password)) {
                        //this will print log in user details
                        out.println("user details: " + mergeArray[i]);
                        while (true) {
                            out.println("1=> press 1 for show record");
                            out.println("2=> press 2 for search record");
                            String choice = scanner1.nextLine();
                            //this is for show record
                            if (choice.equalsIgnoreCase("1")) {
                                out.println("1=> press 'E' for employee");
                                out.println("2=> press 'M' for manager ");
                                out.println("3=> press 'A' for admin");
                                out.println("4=> press 'ALL' for all ");
                                out.println("5=> press '5' for  exit ");
                                while (true) {
                                    out.print("enter your choice : ");
                                    String choice1 = scanner1.nextLine();
                                    switch (choice1) {
                                        case "M":
                                            //this will print all manager list
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains("manager")) {
                                                    out.println(mergeArray[j]);
                                                }
                                            }
                                            break;
                                        case "E":
                                            //this will print all employee list
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains("employee")) {
                                                    out.println(mergeArray[j]);
                                                }
                                            }
                                            break;
                                        case "A":
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains("admin")) {
                                                    out.println(mergeArray[j]);
                                                }
                                            }
                                            break;
                                        case "ALL":
                                            //this will print admin,manager and employee list
                                            for (String s : mergeArray) {
                                                out.println(s);
                                            }
                                            break;
                                        case "5":
                                            // exit the system
                                            System.exit(0);
                                        default:
                                            out.println("incorrect  choice");
                                            break;
                                    }
                                }
                                // this is for search in record
                            } else if (choice.equalsIgnoreCase("2")) {
                                out.println("1=> press 'E' for employee");
                                out.println("2=> press 'M' for manager ");
                                out.println("3=> press 'A' for admin ");
                                out.println("4=> press 'ALL' for all ");
                                out.println("5=> press '5' for  exit ");
                                while (true) {
                                    out.print("enter your choice : ");
                                    String choice2 = scanner1.nextLine();
                                    switch (choice2) {
                                        case "M":
                                            // this will search name in only manager list
                                            out.println("enter name for search in manager list");
                                            String searchManager = scanner1.nextLine();
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains(searchManager) && userLoginArray[j].contains("manager")) {
                                                    out.println(mergeArray[j]);
                                                    flag = false;
                                                    break;
                                                }
                                            }
                                            if (flag) {
                                                out.println("name not found in manager list");
                                            }
                                            break;
                                        case "E":
                                            // this will search name in only employee list
                                            out.println("enter name for search in employee list");
                                            String searchEmployee;
                                            searchEmployee = scanner1.nextLine();
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains(searchEmployee) && userLoginArray[j].contains("employee")) {
                                                    out.println(mergeArray[j]);
                                                    flag = false;
                                                    break;
                                                }
                                            }
                                            if (flag) {
                                                out.println("name not found in employee list");
                                            }
                                            break;
                                        case "A":
                                            // this will search name in only employee list
                                            out.println("enter name for search in admin list");
                                            String searchAdmin;
                                            searchAdmin = scanner1.nextLine();
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains(searchAdmin) && userLoginArray[j].contains("admin")) {
                                                    out.println(mergeArray[j]);
                                                    flag = false;
                                                    break;
                                                }
                                            }
                                            if (flag) {
                                                out.println("name not found in admin list");
                                            }
                                            break;
                                        case "ALL":
                                            // this will search name in all record list
                                            out.println("enter name for search in all record");
                                            String searchAll;
                                            searchAll = scanner1.nextLine();
                                            for (int j = 0; j < userLoginArray.length; j++) {
                                                if (userLoginArray[j].contains(searchAll)) {
                                                    out.println(mergeArray[j]);
                                                    flag = false;
                                                }
                                            }
                                            if (flag) {
                                                out.println("name not found in record");
                                            }
                                            break;
                                        case "5":
                                            // exit the system
                                            System.exit(0);
                                        default:
                                            out.println("enter correct choice");
                                            break;
                                    }
                                }
                            } else {
                                out.println("incorrect choice");
                            }
                        }
                    }
                }
                if (flag) {
                    out.println("incorrect userName or password");
                }
            }
            if (flag) {
                out.println("you enter to many time user name and password");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        out.println(".....welcome to the demo application.....");
        DemoApplication demoApplication = new DemoApplication();
        /*demoApplication.userInfo();
         demoApplication.userLoginInfo();
         demoApplication.mergeFileInfo();*/
        demoApplication.display();
    }
}