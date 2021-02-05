package com.uks.ronak.core.day4;

public class BaseEmployee implements IWork {
    //abstract method
    public void doWork() {
        System.out.println("do work");
    }

    // final  void doWork();// this method cannot be override
    // public static  void doWork();// this method cannot be override
    //private void doWork();//it is clash with iwork method
    // protected void doWork(); // it is clash with iwork method
    private long basicSalary;
    private String firstName;
    public String lastName;
    private String empType;
    private int empCode;

    // constructor for BaseEmployee
    public BaseEmployee(String firstName, String lastName, String empType, long basicSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empType = empType;
        this.basicSalary = basicSalary;
    }

    // constructor  for PLEmployee
    public BaseEmployee(String firstName, String lastName, String empType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empType = empType;
    }

    // constructor  for RowReader
    public BaseEmployee(int empCode, String firstName, String lastName, String empType, long basicSalary) {

        this.empCode = empCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empType = empType;
        this.basicSalary = basicSalary;
    }

    public int getEmpCode() {
        return empCode;
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
}
