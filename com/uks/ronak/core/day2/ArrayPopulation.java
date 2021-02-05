package com.uks.ronak.core.day2;

import java.util.Scanner;

public class ArrayPopulation {
    public static void main(String[] args) {
        PopulateArray populateArray = new PopulateArray();
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        System.out.println("enter 5 element in arr1");
        for (int i = 0; i < 5; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.println("enter 5 element in arr2");
        for (int i = 0; i < 5; i++) {
            arr2[i] = scanner.nextInt();
        }
        populateArray.populateArray(arr1, arr2);
        populateArray.print();
    }
}