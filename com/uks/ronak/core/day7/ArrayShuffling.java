package com.uks.ronak.core.day7;

import java.util.*;

public class ArrayShuffling {
    public void shuffle(String[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            // it is generating a random index for shuffling
            int randomIndex = rand.nextInt(array.length);
            // swapping logic
            String temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        ArrayShuffling arr = new ArrayShuffling();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the size of array");
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[size];
        System.out.println("enter string element");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLine();
        }
        arr.shuffle(array);
    }
}