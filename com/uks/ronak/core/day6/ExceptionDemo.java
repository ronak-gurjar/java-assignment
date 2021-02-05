package com.uks.ronak.core.day6;

import com.sun.org.apache.bcel.internal.generic.IFLE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

class ExceptionDemo {
    public ExceptionDemo() {
        File file = new File("src/com/uks/ronak/core/day5/filead.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
            }
            int num = 10 / 0;
            System.out.println(num);
        } catch (IOException e) {
            System.out.println("iOException occur");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occur");
            e.printStackTrace();
        }
        System.out.println("exception handle");
    }
}