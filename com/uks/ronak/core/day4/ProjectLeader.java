package com.uks.ronak.core.day4;

public class ProjectLeader extends Employee {
    // default value
    private long mobileNumber;

    //  constructor
    public ProjectLeader(String firstName, String lastName, long mobileNumber) {
        super(firstName, lastName, "PL");
        this.mobileNumber = mobileNumber;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    // print method
    public void print() {
        System.out.println("first name = " + this.getFirstName());
        System.out.println("last name  = " + this.getLastName());
        System.out.println("employee type = " + this.getEmpType());
        System.out.println("mobile number = " + this.getMobileNumber() + "\n");
    }
}

