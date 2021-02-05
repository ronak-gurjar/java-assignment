package com.uks.ronak.core.day5;

import java.io.*;
import java.util.Scanner;

public class RowToFileConverter {
    public void rowToFileConverter(String readPath, String writePath) {

        File rFile = new File(readPath);
        File wFIle = new File(writePath);
        // for read data from file
        Scanner scanner = null;
        try {
            scanner = new Scanner(rFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder buffer = new StringBuilder();
        while (scanner.hasNext()) {
            buffer.append(scanner.nextLine()).append("\n");
        }
        // printing file data
        System.out.println(buffer);
        // for write data in another file
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(wFIle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // read line from readFile and copy to another file
        System.out.println("file copied successfully");
    }

    public static void main(String[] args) throws IOException {
        RowToFileConverter rowToFileConverter = new RowToFileConverter();

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the path for readData : [src/com/uks/ronak/core/day5/fileRead.txt]");
        String readPath = scanner.nextLine();
        System.out.println("enter the path for writeData : [src/com/uks/ronak/core/day5/fileWrite.txt]");
        String writePath = scanner.nextLine();
        rowToFileConverter.rowToFileConverter(readPath, writePath);
    }
}
