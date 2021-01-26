package com.uks.ronak.core.day4;

public class PLEmployee extends BaseEmployee implements IReport {
    private long mobileNumber;

    PLEmployee(String firstName, String lastName) {
        super(firstName, lastName, "PL");
    }

    @Override
    public void doWork() {
        System.out.println("do work in PLEmployee");
    }

    public void assignTaskToJunior() {
        System.out.println("assign task to junior in PLEmployee");
    }

    public void collectReportFromJunior() {
        System.out.println("collect report from junior in PLEmployee");
    }

    public void reportToSenior() {
        System.out.println("report to senior in PLEmployee");
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public static void main(String[] args) {
        PLEmployee plEmployee = new PLEmployee("Alex", "Richard");
        System.out.println(plEmployee.getFirstName() + " " + plEmployee.getLastName());
    }
}