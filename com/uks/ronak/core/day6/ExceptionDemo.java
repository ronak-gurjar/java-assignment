package com.uks.ronak.core.day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class ExceptionDemo {
    public void ioException() {
        File file = new File("test.txt");
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException found");
        }
    }

    public void exception() {
        try {
            int num = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception occur");
        }
    }
}

