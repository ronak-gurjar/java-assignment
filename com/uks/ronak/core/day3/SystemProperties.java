package com.uks.ronak.core.day3;

import java.util.Scanner;

public class SystemProperties {
    public static void main(String[] args) {
        ShowSystemProperties showSystemProperties = new ShowSystemProperties();
        Scanner sc = new Scanner(System.in);
        System.out.println("uName = user name");
        System.out.println("oName = os name");
        System.out.println("uDir = user directory");
        System.out.println("all = print all");
        System.out.println("enter your choice");
        // choice is string like uname,oName,uDir,all
        String  choice = sc.nextLine();
        switch (choice) {
            case "uName":
                showSystemProperties.uName();
                break;
            case "oName":
                showSystemProperties.oName();
                break;
            case "uDir":
                showSystemProperties.uDir();
                break;
            case "all":
                showSystemProperties.uName();
                showSystemProperties.oName();
                showSystemProperties.uDir();
                break;
            default:
                System.out.println("enter valid input");
        }
    }
}