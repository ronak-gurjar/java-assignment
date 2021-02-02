package com.uks.ronak.core.day2;

import java.util.Scanner;


public class VowelConstant {
    public void checkChar(char ch) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 => check vowel");

        System.out.print("enter choice=");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
                    System.out.println("it is vowel");
                } else {
                    System.out.println("it is constant");
                }
                break;
            default:
                System.out.println("enter valid choice");
        }
    }
}