package com.uks.ronak.core.day3;

import java.util.Scanner;

public class CallEmployee  {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter name");
        String name=scanner.nextLine();
        System.out.println("enter basic salary");
        long basicSalary=scanner.nextLong();

        Employee.SalaryStructure salaryStructure= new Employee.SalaryStructure(basicSalary);
        Employee employee = new Employee(name);
        System.out.println("name " + " => " + employee.getName());
        System.out.println("basicSalary" + " => " + salaryStructure.getBasicSalary());
        System.out.println("hra" + " => " + salaryStructure.getHra());
        System.out.println("total salary" + " => " + salaryStructure.totSal());
    }
}
