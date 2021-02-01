package com.uks.ronak.core.day4;

public class Employee {
    // declare access modifier for each property
    public String firstName;
    private String lastName;
    protected String empType;

    public Employee(String firstName, String lastName, String empType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empType = empType;
    }

    public String getEmpType() {
        return empType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
