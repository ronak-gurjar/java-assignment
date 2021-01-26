package com.uks.ronak.core.day4;

import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public void print(String Path) {
        // making a file object
        File file = new File(Path);
        // making a file array object to store file name
        File[] files = file.listFiles();
        //C:\Users\hello\Desktop\New folder\companyinfo.txt
        System.out.println("is exist = " + file.exists());
        System.out.println("is directory = " + file.isDirectory());
        System.out.println("is file = " + file.isFile());
        System.out.println("length = " + file.length());
        try {
            if (files != null) {
                for (File value : files) {
                    System.out.print(value.toString() + " --> ");
                    System.out.println(value.getUsableSpace());
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        FileInfo fileInfo = new FileInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the path ");
        String path = scanner.nextLine();
        fileInfo.print(path);
    }
}