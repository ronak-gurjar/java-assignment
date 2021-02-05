package com.uks.ronak.core.day7;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class PersistentEmpList {

    public void serialization(Hashtable<Integer, EmployeeDetail> table) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("src/com/uks/ronak/core/day7/emp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // table data write in object
            objectOutputStream.writeObject(table);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("data serialization successfully\n");
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public void deserialization() throws ClassNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/com/uks/ronak/core/day7/emp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // read the table data and store in table and print the value
            Hashtable<Integer, EmployeeDetail> table = (Hashtable<Integer, EmployeeDetail>) objectInputStream.readObject();
            for (EmployeeDetail em : table.values()) {
                System.out.println(em.name);
                System.out.println(em.age);
                System.out.println(em.basicSalary);
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("data deserialization successfully");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PersistentEmpList emp = new PersistentEmpList();
        Scanner scanner = new Scanner(System.in);
        Hashtable<Integer, EmployeeDetail> table = new Hashtable<>();

        System.out.println("enter size of employee");
        int size = scanner.nextInt();
        String name;
        long basicSalary;
        byte age;
        for (int i = 0; i < size; i++) {
            scanner.nextLine();
            System.out.println("enter name");
            name = scanner.nextLine();

            System.out.println("enter age");
            age = scanner.nextByte();

            System.out.println("enter basic salary");
            basicSalary = scanner.nextLong();
            // all data store in table
            table.put(i, new EmployeeDetail(name, age, basicSalary));
        }
        emp.serialization(table);
        emp.deserialization();
    }
}