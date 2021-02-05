package com.uks.ronak.core.day7;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecutionInfo {
    public void memoryUsage() throws FileNotFoundException {
        Runtime time = Runtime.getRuntime();
        long startTime = System.nanoTime();
        long beforeUsedMem = time.totalMemory() - time.freeMemory();
        System.out.println("before use memory : " + beforeUsedMem);
        FindInFiles findInFiles = new FindInFiles();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the String");
        String string = scanner.nextLine();

        System.out.println("enter filepath or directory");
        String filepath = scanner.nextLine();

        findInFiles.search(string, filepath);

        long afterUsedMem = time.totalMemory() - time.freeMemory();
        System.out.println("after use memory : " + afterUsedMem);

        long actualMemUsed = (afterUsedMem - beforeUsedMem);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("execution time in nano second : " + duration);
        System.out.println("differance of memory usage in bytes: " + actualMemUsed);

        System.gc();
        // after calling garbage collection
        System.out.println("--------------------------");
        long afterUsedMem1 = time.totalMemory() - time.freeMemory();
        System.out.println("after use memory : " + afterUsedMem1);
        //home/reo/Desktop
        long actualMemUsed1 = (afterUsedMem1 - beforeUsedMem);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime;

        System.out.println("execution time in nano second : " + duration1);
        System.out.println("differance of memory usage in bytes: " + actualMemUsed1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ExecutionInfo executionInfo = new ExecutionInfo();
        executionInfo.memoryUsage();
    }
}