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
    public void search(String string, String filepath) throws FileNotFoundException {
        int lineNum = 0;
        boolean flag = true;
        File file = new File(filepath);
        File[] fileList = file.listFiles();
        Pattern pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        try {
            if (fileList != null) {
                for (File data : fileList) {
                    if (data.isDirectory()) {
                        search(string, data.toString());

                    } else {
                        Scanner scanner = new Scanner(data);
                        while (scanner.hasNextLine()) {
                            String data1 = scanner.nextLine();
                            matcher = pattern.matcher(data1);
                            lineNum++;
                            if (matcher.find()) {
                                System.out.println(data.getAbsolutePath() + "  in \"" + string + "\"" + " " + "found at line number:" + lineNum);
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (flag) {
                    System.out.println("string not found");
                }
            } else {
                System.out.println(file.getAbsoluteFile() + "-->" + "null files");
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}