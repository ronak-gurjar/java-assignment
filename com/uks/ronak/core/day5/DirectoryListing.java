package com.uks.ronak.core.day5;

import java.io.*;
import java.util.Scanner;

public class DirectoryListing {

    public void print(String filePath, boolean recursive, String[] extension) throws IOException {
        File file = new File(filePath);

        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (File data : fileList) {
                if (data.isDirectory() == recursive) {
                    //recursive call
                    print(data.getAbsolutePath(), recursive, extension);
                }
                for (String ext : extension) {
                    if (data.toString().endsWith(ext)) {
                        System.out.println("file=" + data.getAbsoluteFile());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DirectoryListing directoryListing = new DirectoryListing();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the file path");
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        // validate directory
        if (file.isDirectory() && file.exists()) {
            System.out.println("enter coma separated extension");
            // enter coma separated extension which is store in arr[]
            String extension = scanner.nextLine();
            String[] arr = extension.split(",");
            try {
                directoryListing.print(filePath, true, arr);
            } catch (IOException ioException) {
                System.out.println("IOException occur");
            }
        } else {
            System.out.println("directory is not exist");
        }
    }
}