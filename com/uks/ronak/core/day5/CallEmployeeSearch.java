package com.uks.ronak.core.day5;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CallEmployeeSearch {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter last name for search");
        String lastName = sc.nextLine();
        EmployeeSearch employeeSearch = new EmployeeSearch();
        employeeSearch.employeeSearch(lastName);
    }
}
