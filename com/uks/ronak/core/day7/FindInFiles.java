package com.uks.ronak.core.day7;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindInFiles {

    // read file
    public void read(String filepath) {
        File file = new File(filepath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("file not found");
        }
        StringBuilder buffer = new StringBuilder();
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine()).append("\n");
            }
        }
        System.out.println(buffer);
    }

    // search in file
    public void search(String searchString, String filepath) {

        boolean flag = true;
        File file = new File(filepath);
        File[] fileList = file.listFiles();
        Pattern pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE);
        try {
            if (fileList != null) {
                for (File data : fileList) {
                    if (data.isDirectory()) {
                        search(searchString, data.toString());

                    } else {
                        int lineNum = 0;
                        Scanner scanner = new Scanner(data);
                        while (scanner.hasNextLine()) {
                            String data1 = scanner.nextLine();
                            Matcher matcher = pattern.matcher(data1);
                            lineNum++;
                            if (matcher.find()) {
                                System.out.println(data.getAbsolutePath() + "  in \"" + searchString + "\"" + " " + "found at line number:" + lineNum);
                            }
                        }
                    }
                }
            } else {
                int line = 0;
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String data2 = scanner.nextLine();
                    Matcher matcher = pattern.matcher(data2);
                    line++;
                    if (matcher.find()) {
                        System.out.println(file.getAbsolutePath() + "  in \"" + searchString + "\"" + " " + "found at line number:" + line);
                    }
                }
            }
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println(e);
        }
    }
}