package com.uks.ronak.core.day4;

import com.uks.ronak.core.day6.InvalidInputException;

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
        long totalSize = 0;
        if (files != null) {
            for (File value : files) {
                System.out.print(value.toString() + " --> ");
                System.out.println(value.length());
                totalSize += value.length();
            }
            System.out.println("totalSize dir size -> " + totalSize);
        } else {
            System.out.println(file.toString() + " -> " + file.length());
        }
    }

    public static void main(String[] args) {
        FileInfo fileInfo = new FileInfo();

        fileInfo.print(args[0]);
    }
}