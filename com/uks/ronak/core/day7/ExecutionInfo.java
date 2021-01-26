package com.uks.ronak.core.day7;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecutionInfo {
    public void memoryUsage() throws FileNotFoundException {
        FindInFiles findInFiles = new FindInFiles();
        Runtime time = Runtime.getRuntime();
        long startTime = System.nanoTime();
        long beforeUsedMem = time.totalMemory() - time.freeMemory();
        System.out.println("before use memory : " + beforeUsedMem);
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
        System.out.println("execution time nano second : " + duration);
        System.out.println(" differance of memory usage in bytes: " + actualMemUsed);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ExecutionInfo executionInfo = new ExecutionInfo();
        executionInfo.memoryUsage();
    }
}