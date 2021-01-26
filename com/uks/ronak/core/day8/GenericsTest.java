package com.uks.ronak.core.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GenericsTest {

    private HashMap<Long, String> numberNameList = new HashMap<>();

    public void addToDictionary(long mobileNumber, String firstName) {
        for (int i = 0; i < 3; i++) {
            numberNameList.put(mobileNumber, firstName);
        }
    }

    public void searchMobile(long mobileNumber) {
        // searching mobile number and print result
        if (numberNameList.containsKey(mobileNumber)) {
            System.out.println("this is " + numberNameList.get(mobileNumber) + "'s mobile number :" + mobileNumber);
        } else {
            System.out.println("number not found");
        }
    }

    public void printAll() {
        //printing key and value
        for (Map.Entry<Long, String> entry : numberNameList.entrySet()) {
            Long key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Name : " + value);
            System.out.println("mobileNumber : " + key);
        }
    }

    public static void main(String[] args) {
        GenericsTest genericsTest = new GenericsTest();
        Scanner scanner = new Scanner(System.in);
        long mNumber;
        String firstName;
        for (int i = 0; i < 3; i++) {
            System.out.println("enter mobile number");
            mNumber = scanner.nextLong();
            scanner.nextLine();
            System.out.println("enter first name");
            firstName = scanner.nextLine();
            genericsTest.addToDictionary(mNumber, firstName);
        }
        genericsTest.printAll();
        System.out.println("enter mobile number for search :");
        mNumber = 0;
        try {
            mNumber = scanner.nextLong();
        } catch (Exception e) {
            System.out.println("invalid input");
        }
        genericsTest.searchMobile(mNumber);
    }
}
