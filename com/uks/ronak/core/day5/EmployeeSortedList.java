package com.uks.ronak.core.day5;

import java.util.*;

public class EmployeeSortedList implements Comparable<EmployeeSortedList> {
    @Override
    public int compareTo(EmployeeSortedList o) {
        return this.empCode - o.empCode;
    }

    private long basicSalary;
    private String firstName;
    private String lastName;
    private String empType;
    private int empCode;

    public EmployeeSortedList(int empCode, String firstName, String lastName, String empType, long basicSalary) {
        this.empCode = empCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empType = empType;
        this.basicSalary = basicSalary;
    }

    public long getBasicSalary() {
        return basicSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmpType() {
        return empType;
    }

    public int getEmpCode() {
        return empCode;
    }

}

