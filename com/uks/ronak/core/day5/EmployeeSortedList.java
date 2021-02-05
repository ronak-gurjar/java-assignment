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

class FName implements Comparator<EmployeeSortedList> {

    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

class LName implements Comparator<EmployeeSortedList> {

    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

class EType implements Comparator<EmployeeSortedList> {
    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return o1.getEmpType().compareTo(o2.getEmpType());
    }
}

class Salary implements Comparator<EmployeeSortedList> {

    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return (int) (o1.getBasicSalary() - o2.getBasicSalary());
    }
}

