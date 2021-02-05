package com.uks.ronak.core.day2;

import java.util.Scanner;

class StringManipulation {
    public void doOperationWithRegEx(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter num 1 to reverse string and num 2 count upper,lower string : ");
        int num = scanner.nextInt();
        //  System.out.println(buffer.reverse());
        if (num == 1) {
            String[] split = string.split(" ");
            // we want only first word of string
            string = split[0];
            StringBuilder buffer = new StringBuilder();
            // we have to convert our string into char array
            char[] arr = string.toCharArray();
            for (int j = arr.length - 1; j >= 0; j--) {
                buffer.append(arr[j]);
            }
            System.out.println(buffer);
        } else if (num == 2) {
            // making a three variable to counting a upper,lower and number
            int upper = string.split("([A-Z])").length;
            int lower = string.split("([a-z])").length;
            int number = string.split("([0-9])").length;

            System.out.println("upper=" + (upper - 1));
            System.out.println("lower=" + (lower - 1));
            System.out.println("number=" + number);
            //System.out.println("special character="+ special);
        } else {
            System.out.println("num is not valid");
        }
    }

    // assignment 4 question
    public void doOperation(String st) {
        int upper = 0, lower = 0, number = 0, special = 0;
        for (int i = 0; i < st.length(); i++) {
            // ch=for counting char to char
            char ch = st.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                upper++;
            else if (ch >= 'a' && ch <= 'z')
                lower++;
            else if (ch >= '0' && ch <= '9')
                number++;
            else
                special++;
        }
        System.out.println("Lower case letters : " + lower);
        System.out.println("Upper case letters : " + upper);
        System.out.println("Number : " + number);
        System.out.println("special : " + special);
    }
}
