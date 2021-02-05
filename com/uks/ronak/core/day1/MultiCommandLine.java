package com.uks.ronak.core.day1;

import com.uks.ronak.core.day6.InvalidInputException;

import java.util.Scanner;

//public class MultiCommandLine extends UserNamePassword {
public class MultiCommandLine {
    public void doOperation(int num, String... arr) {
        int sum = 0;
        if (num == 1) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[j]);
                } catch (NumberFormatException e) {
                    System.out.println(arr[j] + " not a number");
                }
            }
            System.out.println("sum=" + sum);
        } else if (num == 2) {
            for (String i : arr) {
                System.out.println(i.toLowerCase());
            }
        } else {
            System.out.println("num is not valid");
        }
    }

    // this function for day6 assignment 1
    public void doOperation(int choice) {
        Scanner scanner = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("enter three number");
            int[] arr = new int[3];
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }
            System.out.println("sum" + sum);
        } else {
            System.out.println("enter string");
            String str = scanner.nextLine();
            System.out.println(str.toLowerCase());
        }
    }

    public static void main(String[] args) throws InvalidInputException {
        MultiCommandLine multiCommandLine = new MultiCommandLine();
        Scanner scanner = new Scanner(System.in);
        // this is extended class UserNamePassword method
        // multiCommandLine.validate("ronak",1234);
        // commandline :src>javac com/uks/ronak/core/day1/MultiCommandLine.java
        System.out.println("enter 1 for addition or 2 for lowercase");
        int ch = scanner.nextInt();
        System.out.println();
        multiCommandLine.doOperation(ch);
    }
}