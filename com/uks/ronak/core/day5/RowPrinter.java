package com.uks.ronak.core.day5;

import com.uks.ronak.core.day4.BaseEmployee;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class RowPrinter {
    public void print() {
        List<BaseEmployee> st = RowReader.readData("src/com/uks/ronak/core/day5/employeeData.txt");
        for (BaseEmployee baseEmployee : st) {
            System.out.print(baseEmployee.getEmpCode() + " ");
            System.out.print(baseEmployee.getFirstName() + " ");
            System.out.print(baseEmployee.getLastName() + " ");
            System.out.print(baseEmployee.getEmpType() + " ");
            System.out.print(baseEmployee.getBasicSalary() + "\n");
        }
    }
    // this method for EmployeeSortedList
    public  void printTabular() throws FileNotFoundException {
        Scanner scanner=new Scanner(System.in);
        EmployeeSortedList employee = new EmployeeSortedList(1, "dd", "fff", "dsd", 5);
        System.out.println("enter collum name for sort");
        String cName= scanner.nextLine();
        List<EmployeeSortedList> list = employee.sortedList(cName);
        System.out.println("empCode   EmployeeName     EmpType    salary");
        System.out.println("-------------------------------------------------");
        for (EmployeeSortedList employeeSortedList : list) {
            System.out.printf("%1s", employeeSortedList.getEmpCode());
            System.out.printf("%10s", employeeSortedList.getFirstName() + " ");
            System.out.printf("%5s", employeeSortedList.getLastName());
            System.out.printf("%15s", employeeSortedList.getEmpType());
            System.out.printf("%10s", employeeSortedList.getBasicSalary() + "\n");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        RowPrinter rowPrinter= new RowPrinter();
        rowPrinter.print();
       rowPrinter.printTabular();
    }
}