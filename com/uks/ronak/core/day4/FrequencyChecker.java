package com.uks.ronak.core.day4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FrequencyChecker {
    public void frequencyChecker(String[] string) {
        // in treemap print string in dictionary order
        Map<String, Integer> map = new TreeMap<>();
        // in hashmap print string in random order
        // Map<String, Integer> map = new HashMap<>();

        for (String s : string) {
            // Condition to check if the array element is present the map
            if (map.containsKey(s)) {
                // if word present in map -> increment 1
                map.put(s, map.get(s) + 1);
            } else {
                //else word frequency is -> 1
                map.put(s, 1);
            }
        }
        // printing word frequency
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        FrequencyChecker frequencyChecker = new FrequencyChecker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the size of array");
        String size = scanner.nextLine();

        String[] string = new String[Integer.parseInt(size)];
        System.out.println("enter the string");

        for (int i = 0; i < Integer.parseInt(size); i++) {
            string[i] = scanner.nextLine();
        }
        frequencyChecker.frequencyChecker(string);
    }
}