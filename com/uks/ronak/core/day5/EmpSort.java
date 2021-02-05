package com.uks.ronak.core.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmpSort {

    // constant values
    public static final String eCODE = "ecode";
    public static final String fName = "fname";
    public static final String lName = "lname";
    public static final String eType = "etype";
    public static final String salary = "salary";

    public List<EmployeeSortedList> sortedList(String cName) throws FileNotFoundException {
        File file = new File("src/com/uks/ronak/core/day5/employeeData.txt");
        Scanner scanner = new Scanner(file);
        String data;
        List<EmployeeSortedList> list = new ArrayList<>();
        while (scanner.hasNext()) {
            data = scanner.nextLine();
            String[] token = data.split(",");
            EmployeeSortedList employee = new EmployeeSortedList(Integer.parseInt(token[0]), token[1], token[2], token[3], Long.parseLong(token[4]));
            list.add(employee);
        }
        switch (cName) {
            case eCODE:
                Collections.sort(list);
                //Collections.reverse(list);
                break;
            case fName:
                // Collections.sort(list,new FName());
                list.sort(new FName());
                break;
            case lName:
                list.sort(new LName());
                break;
            case eType:
                list.sort(new EType());
                break;
            case salary:
                list.sort(new Salary());
                break;
            default:
                System.out.println("wrong choice");
                break;
        }
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        EmpSort empSort = new EmpSort();
        System.out.println("1 -> default sorting based on empcode ");
        System.out.println("or choose [fname],[lname],[salary],[etype]");
        String cName = scanner.nextLine();
        if (cName.equals("1")) {
            empSort.sortedList("ecode");
        } else {
            empSort.sortedList(cName);
        }
        // call RowPrinter class static method
        RowPrinter.printTabular(cName);
    }
}
