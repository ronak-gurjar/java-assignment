package com.uks.ronak.core.day8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpInfoMerger extends Thread {
    String file;
    String mode;
    // shared variable for store file data
    static List<String> list = new ArrayList<>();

    EmpInfoMerger(String file, String mode) {
        this.file = file;
        this.mode = mode;
    }

    public void writeToResource() throws IOException, InterruptedException {
        File fileRead = new File(file);
        Scanner scanner = new Scanner(fileRead);

        while (scanner.hasNextLine()) {
            synchronized (this) {
                list.add(scanner.nextLine());
                sleep(1000);
            }
        }
    }

    public void writeToFile() throws IOException, InterruptedException {
        File fileWrite = new File(file);
        if (fileWrite.exists()) {
            if (list != null) {
                FileWriter write = new FileWriter(fileWrite, true);
                if (list == null) {
                    System.out.println("shared variable is null");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        synchronized (this) {
                            String str = list.get(i);
                            write.write(str + "\n");
                            System.out.println(str);
                        }
                    }
                }
                list.clear();
                sleep(2000);
                write.close();
            }
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
                sleep(2000);
                writeToFile();
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void print() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        EmpInfoMerger nameFileRead = new EmpInfoMerger("/home/reo/IdeaProjects/brilworks assignment/src/com/uks/ronak/core/day8/name.txt", "read");
        EmpInfoMerger addFileRead = new EmpInfoMerger("/home/reo/IdeaProjects/brilworks assignment/src/com/uks/ronak/core/day8/address.txt", "read");
        EmpInfoMerger newFileWrite = new EmpInfoMerger("/home/reo/IdeaProjects/brilworks assignment/src/com/uks/ronak/core/day8/newFileName.txt", "write");
        nameFileRead.start();
        // addFile thread sleep for 20ms
        sleep(20);
        addFileRead.start();
        sleep(2000);
        newFileWrite.start();
    }
}
