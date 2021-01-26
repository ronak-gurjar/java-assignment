package com.uks.ronak.core.day3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TestStringTokenizer {
    public static void print(String string) {
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken(","));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the comma separate string");
        String string = scanner.nextLine();
        // string print line by line
        print(string);
    }
}