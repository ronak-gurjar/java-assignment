package com.uks.ronak.core.day5;

import java.io.*;
import java.util.Scanner;

public class RowToFileConverter {
    public void rowToFileConverter(String readPath, String writePath) throws IOException {

        File rFile = new File(readPath);
        File wFIle = new File(writePath);
        // for read data from file
        Scanner scanner = new Scanner(rFile);
        StringBuilder buffer = new StringBuilder();
        while (scanner.hasNext()) {
            buffer.append(scanner.nextLine()).append("\n");
        }
        // printing file data
        System.out.println(buffer);
        // for write data in another file
        FileWriter fileWriter = new FileWriter(wFIle);
        fileWriter.write(buffer.toString());
        fileWriter.flush();
        // read line from readFile and copy to another file
        System.out.println("file copied successfully");
    }

    public static void main(String[] args) throws IOException {
        RowToFileConverter rowToFileConverter = new RowToFileConverter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the path for readData : [src\\com\\uks\\ronak\\core\\day5\\fileRead.txt]");
        String readPath = scanner.nextLine();
        System.out.println("enter the path for writeData : [src\\com\\uks\\ronak\\core\\day5\\fileWrite.txt]");
        String writePath = scanner.nextLine();
        rowToFileConverter.rowToFileConverter(readPath, writePath);
        //  RowReader.rowToFile("src/com/uks/ronak/core/day5/employeeData.txt");
    }
}
