package com.uks.ronak.core.day5;

import java.io.File;

public class aaaa {
    public void walk(String path, String ext) {
        File root = new File(path);
        File[] list = root.listFiles();
        assert list != null;
        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath(), ext);
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                // System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }

    public static void main(String[] args) {
        aaaa b = new aaaa();
        b.walk("C:/Users/hello/Desktop", ".txt");
    }
}
