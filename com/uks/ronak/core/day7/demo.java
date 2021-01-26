package com.uks.ronak.core.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public void fileSearch(String string, String filepath) throws FileNotFoundException {
        int lineNum = 0;
        boolean flag = true;
        File file = new File(filepath);
        File[] fileList = file.listFiles();
        Pattern pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        assert fileList != null;
        for (File data : fileList) {
            if (data.isDirectory()) {
                fileSearch(string, data.getAbsolutePath());
                Scanner scanner = new Scanner(data.toString());
                while (scanner.hasNextLine()) {
                    String data1 = scanner.nextLine();
                    matcher = pattern.matcher(data1);
                    lineNum++;
                    if (matcher.find()) {
                        System.out.println(data.getAbsoluteFile() + "  in \"" + string + "\"" + " " + "found at line number:" + lineNum);
                        break;
                    }
                }
            } else {
                Scanner scanner = new Scanner(data);
                while (scanner.hasNextLine()) {
                    String data1 = scanner.nextLine();
                    matcher = pattern.matcher(data1);
                    lineNum++;
                    if (matcher.find()) {
                        System.out.println(data.getName() + "  in \"" + string + "\"" + " " + "found at line number:" + lineNum);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        demo d = new demo();
        d.fileSearch("gurjar", "C:\\Users\\hello\\Desktop");
    }
}
/*package com.uks.ronak.core.day8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpInfoMerger extends Thread {
    String file;
    String mode;
    // shared variable that store the file data
    static StringBuilder storeFileData;

    EmpInfoMerger(String file, String mode) {
        this.file = file;
        this.mode = mode;
    }
static List<String> list= new ArrayList<>();
    public synchronized void writeToResource() throws IOException, InterruptedException {
        FileReader fileRead = new FileReader(file);
        StringBuilder data = new StringBuilder();
        BufferedReader br= new BufferedReader(fileRead);

        Scanner scanner = new Scanner(fileRead);
        while (scanner.hasNextLine()) {
           // storeFileData = data.append(scanner.nextLine()).append("\n");
            list.add(scanner.nextLine());
            Thread.sleep(1000);
            System.out.println(list);
        }
       // System.out.println(storeFileData);
    }

    public synchronized void writeToFile() throws IOException, InterruptedException {
        File fileWrite = new File(file);
        if (fileWrite.exists()) {
            FileWriter write = new FileWriter(fileWrite, true);
            if (storeFileData == null) {
                System.out.println("shared variable is null");
            } else {
                write.write(storeFileData.toString());
                System.out.println("successfully write in file");
                Thread.sleep(2000);
            }
            write.close();
        } else {
            fileWrite.createNewFile();
            writeToFile();
        }
    }

    public void run() {
        if (mode.equalsIgnoreCase("read")) {
            try {
                writeToResource();
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        } else {
            try {
                writeToFile();
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EmpInfoMerger newFileWrite = new EmpInfoMerger("src\\com\\uks\\ronak\\core\\day8\\newFileName.txt", "write");

        EmpInfoMerger nameFileRead = new EmpInfoMerger("src\\com\\uks\\ronak\\core\\day8\\name.txt", "read");
        nameFileRead.writeToResource();
        newFileWrite.writeToFile();

        EmpInfoMerger addFileRead = new EmpInfoMerger("src\\com\\uks\\ronak\\core\\day8\\address.txt", "read");
        addFileRead.writeToResource();
        newFileWrite.writeToFile();

        Thread nameThread = new Thread(nameFileRead);
        nameThread.start();
        Thread addThread = new Thread(addFileRead);
        addThread.start();
    }
}
*/