package com.uks.ronak.core.day3;

import java.util.Scanner;

public class CallClassDetails extends ClassDetails {

    public static void main(String[] args) {
        CallClassDetails callClassDetails = new CallClassDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the name of class:[com.uks.ronak.core.dayX.XXXXXXX]");
        String className = scanner.nextLine();
        Class cls = null;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
        if (cls != null) {
            System.out.println("enter typeOfInfo[ALL],[M],[F],[C]");
            String typeOfInfo = scanner.nextLine();
            try {
                callClassDetails.classDetails(className, typeOfInfo);
            } catch (ClassNotFoundException e) {
                System.out.println("class not found");
            }
        }
    }
}
