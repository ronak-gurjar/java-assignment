package com.uks.ronak.core.day7;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CallFindInFile {
    public static void main(String[] args) throws FileNotFoundException {
        FindInFiles findInFiles = new FindInFiles();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter string for search");
        String string = scanner.nextLine();
        System.out.println("enter file path or directory");
        String filepath = scanner.nextLine();
        findInFiles.search(string, filepath);
        //findInFiles.read(filepath);

    }
}

