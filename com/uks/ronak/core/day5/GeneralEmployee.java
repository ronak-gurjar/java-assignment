package com.uks.ronak.core.day5;

import com.uks.ronak.core.day4.BaseEmployee;

import java.io.IOException;

public class GeneralEmployee extends BaseEmployee {

    @Override
    public void doWork() {
        System.out.println("hello world");
    }

    public GeneralEmployee(String firstName, String lastName, String empType, long basicSalary) {
        super(firstName, lastName, empType, basicSalary);
    }
    public static void main(String[] args) throws IOException {

    }
}