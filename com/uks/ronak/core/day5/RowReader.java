package com.uks.ronak.core.day5;

import com.uks.ronak.core.day4.BaseEmployee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RowReader {

    public static List<BaseEmployee> readData(String filePath) {
        List<BaseEmployee> baseEmployees = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            String data;
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                String[] token = data.split(",");
                BaseEmployee employee = new BaseEmployee(Integer.parseInt(token[0]), token[1], token[2], token[3], Long.parseLong(token[4]));
                baseEmployees.add(employee);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return baseEmployees;
    }

    // this method for RowToFileConverter Class
    public static void rowToFile(String path) throws IOException {
        File rFile = new File(path);
        File wFIle = new File("src/com/uks/ronak/core/day5/copyEmployee.txt");

        StringBuilder buffer = new StringBuilder();
        Scanner scanner = new Scanner(rFile);
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

    // this method for employeeSearch class
    public static Map<Integer, BaseEmployee> keyValuePair() {
        Map<Integer, BaseEmployee> baseEmployees = new HashMap<>();
        File file = new File("src/com/uks/ronak/core/day5/employeeData.txt");
        try (Scanner scanner = new Scanner(file)) {
            String data;
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                String[] token = data.split(",");
                BaseEmployee employee = new BaseEmployee(token[1], token[2], token[3], Long.parseLong(token[4]));
                baseEmployees.put(Integer.parseInt(token[0]), employee);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return baseEmployees;
    }
}