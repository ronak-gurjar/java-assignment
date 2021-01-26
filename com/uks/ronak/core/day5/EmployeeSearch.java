package com.uks.ronak.core.day5;

import com.uks.ronak.core.day4.BaseEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EmployeeSearch {
    public Map<Integer, BaseEmployee> employeeSearch(String lastName) throws FileNotFoundException {
        Map<Integer, BaseEmployee> list = new HashMap<>();
        boolean flag = true;
        File file = new File("src/com/uks/ronak/core/day5/employeeData.txt");
        Scanner scanner = new Scanner(file);
        String data;
        while (scanner.hasNext()) {
            data = scanner.nextLine();
            String[] token = data.split(",");
            BaseEmployee employee = new BaseEmployee(token[1], token[2], token[3], Long.parseLong(token[4])) {
                @Override
                public void doWork() {
                    System.out.println("");
                }
            };
            list.put(Integer.parseInt(token[0]), employee);
            if (token[2].contains(lastName)) {
                System.out.println(Integer.parseInt(token[0]));
                System.out.println(employee.getFirstName());
                System.out.println(employee.getLastName());
                System.out.println(employee.getEmpType());
                System.out.println(employee.getBasicSalary());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("last name not found in record");
        }
        return list;
    }
    // print all employee details
    public void print() {
        Map<Integer, BaseEmployee> m = RowReader.keyValuePair();
        for (Map.Entry<Integer, BaseEmployee> map : m.entrySet()) {
            System.out.print(map.getKey() + " --> ");
            System.out.print(map.getValue().getFirstName() + " ");
            System.out.print(map.getValue().getLastName() + " ");
            System.out.print(map.getValue().getEmpType() + " ");
            System.out.print(map.getValue().getBasicSalary() + "\n");
        }
    }
}
