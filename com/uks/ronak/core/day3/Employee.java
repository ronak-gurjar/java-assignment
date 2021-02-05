package com.uks.ronak.core.day3;

import java.util.Scanner;

public class Employee {
    private final String name;

    // make employee constructor
    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // inner class
    static class SalaryStructure {
        Scanner scanner = new Scanner(System.in);
        private final double basicSalary;
        private double hra;
        double totalSalary;

        // make salaryStructure constructor
        SalaryStructure(long basicSalary) {
            this.basicSalary = basicSalary;
        }

        public double getBasicSalary() {
            return basicSalary;
        }

        public double getHra() {
            return (basicSalary * 12.5) / 100d;
        }

        public double totSal() {
            totalSalary = getBasicSalary() + getHra();
            return totalSalary;
        }
    }

}