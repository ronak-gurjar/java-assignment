package com.uks.ronak.core.day5;

import com.uks.ronak.core.day7.FindInFiles;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CallFindInFile {
    public static void main(String[] args) {
        FindInFiles findInFiles = new FindInFiles();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the String");
        String string = scanner.nextLine();

        System.out.println("enter filepath or directory");
        String filepath = scanner.nextLine();
        try {
            findInFiles.search(string, filepath);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException);
        }
    }
}
