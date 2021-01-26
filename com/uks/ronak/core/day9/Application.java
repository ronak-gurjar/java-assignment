package com.uks.ronak.core.day9;

import java.io.*;
import java.util.*;

public class Application {
    ArrayList<EmpInfo> userLogInInfoData = new ArrayList<>();
    ArrayList<EmpInfo> userInfoData = new ArrayList<>();
    ArrayList<EmpInfo> mergeData = new ArrayList<>();

    // this method read userLogInInfo file and store data in UserLogInInfoData
    public ArrayList<EmpInfo> userLogInInfoRead(String filepath) throws FileNotFoundException {
        String data;
        String[] userLogInInfoToken;
        File userLogInInfoFile = new File(filepath);
        Scanner scanner = new Scanner(userLogInInfoFile);
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            userLogInInfoToken = data.split(",");
            EmpInfo empInfo = new EmpInfo(Integer.parseInt(userLogInInfoToken[0]), userLogInInfoToken[1], userLogInInfoToken[2], userLogInInfoToken[3]);
            userLogInInfoData.add(empInfo);
        }
        return userLogInInfoData;
    }

    // this method read userInfo file and store data in UserInfoData
    public ArrayList<EmpInfo> userInfoRead(String filepath) throws FileNotFoundException {
        String data;
        String[] userInfoToken;
        File userInfoFile = new File(filepath);
        Scanner scanner = new Scanner(userInfoFile);
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            userInfoToken = data.split(",");
            EmpInfo empInfo2 = new EmpInfo(Integer.parseInt(userInfoToken[0]), userInfoToken[1], userInfoToken[2], userInfoToken[3], userInfoToken[4], Long.parseLong(userInfoToken[5]), Long.parseLong(userInfoToken[6]));
            userInfoData.add(empInfo2);
        }
        return userInfoData;
    }

    public ArrayList<EmpInfo> mergeFileWrite(String filepath) throws IOException, ClassNotFoundException {
        File mergeFile = new File(filepath);
        FileWriter fileWriter = new FileWriter(mergeFile);
        mergeData.addAll(userInfoData);
        // serialization
        FileOutputStream fous = new FileOutputStream(mergeFile);
        ObjectOutputStream oos = new ObjectOutputStream(fous);
        oos.writeObject(mergeData);
        fous.close();
        oos.close();
        // deserialization
        FileInputStream fin = new FileInputStream(mergeFile);
        ObjectInputStream oin = new ObjectInputStream(fin);
        ArrayList<EmpInfo> data = (ArrayList<EmpInfo>) oin.readObject();
        oin.close();
        fin.close();
        for (int i = 0, userLogInInfoDataSize = userLogInInfoData.size(); i < userLogInInfoDataSize; i++) {
            String role = userLogInInfoData.get(i).getUserRole();
            fileWriter.write(role + "\n");
        }
        fileWriter.close();
        return mergeData;
    }

    // print mergeData
    public void printMergeData() {
        for (EmpInfo e : mergeData) {
            System.out.print(e.getUserId() + " ");
            System.out.print(e.getFirstName() + " ");
            System.out.print(e.getLastName() + " ");
            System.out.print(e.getAddress() + " ");
            System.out.print(e.getCity() + " ");
            System.out.print(e.getBasicSalary() + " ");
            System.out.println(e.getMobileNumber() + " ");
        }
    }

    // printing userLogInInfoFile data
    public void printUserLogInInfo() {
        for (EmpInfo e : userLogInInfoData) {
            System.out.print(e.getUserId() + "  ");
            System.out.print(e.getUserName() + " ");
            System.out.print(e.getPassword() + " ");
            System.out.println(e.getUserRole() + " ");
        }
    }

    // printing userInfoFile data
    public void printUserInfo() {
        for (EmpInfo e : userInfoData) {
            System.out.print(e.getUserId() + " ");
            System.out.print(e.getFirstName() + " ");
            System.out.print(e.getLastName() + " ");
            System.out.print(e.getAddress() + " ");
            System.out.print(e.getCity() + " ");
            System.out.print(e.getBasicSalary() + " ");
            System.out.println(e.getMobileNumber() + " ");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Application a = new Application();
        a.userLogInInfoRead("src/com/uks/ronak/core/day9/UserLoginInfo.txt");
        a.userInfoRead("src/com/uks/ronak/core/day9/UserInfo.txt");
        a.mergeFileWrite("src/com/uks/ronak/core/day9/mergeFile.txt");
          a.printMergeData();
    }
}