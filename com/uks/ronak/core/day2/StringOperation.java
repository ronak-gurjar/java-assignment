package com.uks.ronak.core.day2;

import java.util.Scanner;

public class StringOperation extends StringManipulation {
    public static void main(String[] args) {
        StringManipulation stringManipulation = new StringManipulation();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter string");
        String string = scanner.nextLine();
        stringManipulation.doOperationWithRegEx(string);
        // assignment 4 question
        //  stringManipulation.doOperation(string);
    }
}
