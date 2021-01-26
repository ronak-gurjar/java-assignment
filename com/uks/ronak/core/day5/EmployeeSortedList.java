package com.uks.ronak.core.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EmployeeSortedList implements Comparable<EmployeeSortedList> {
    @Override
    public int compareTo(EmployeeSortedList o) {
        return this.empCode - o.empCode;
    }

    class FName implements Comparator<EmployeeSortedList> {

        @Override
        public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
            return o1.firstName.compareTo(o2.firstName);
        }
    }

    class LName implements Comparator<EmployeeSortedList> {

        @Override
        public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
            return o1.lastName.compareTo(o2.lastName);
        }
    }

    class EType implements Comparator<EmployeeSortedList> {
        @Override
        public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
            return o1.empType.compareTo(o2.empType);
        }
    }

    class Salary implements Comparator<EmployeeSortedList> {

        @Override
        public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
            return (int) (o1.basicSalary - o2.basicSalary);
        }
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

    List<EmployeeSortedList> list = new ArrayList<>();

    public void print() {
        for (EmployeeSortedList employeeSortedList : list) {
            System.out.printf("%1s", employeeSortedList.getEmpCode());
            System.out.printf("%10s", employeeSortedList.getFirstName() + " ");
            System.out.printf("%5s", employeeSortedList.getLastName());
            System.out.printf("%15s", employeeSortedList.getEmpType());
            System.out.printf("%10s", employeeSortedList.getBasicSalary() + "\n");
        }
    }

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
        RowPrinter rowPrinter = new RowPrinter();
        EmployeeSortedList employeeSortedList = new EmployeeSortedList(1, "dfd", "Ddd", "dd", 2);
        System.out.println("1 -> default sorting base on emocode ");
        System.out.println("or choose [fname],[lname],[salary],[etype]");
        String cName = scanner.nextLine();
        if (cName.equals("1")) {
            employeeSortedList.sortedList("ecode");
            employeeSortedList.print();
        } else {
            employeeSortedList.sortedList(cName);
            employeeSortedList.print();
        }
    }
}

