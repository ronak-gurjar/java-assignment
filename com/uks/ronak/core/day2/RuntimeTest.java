package com.uks.ronak.core.day2;

import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuntimeTest {
    // open notepad using processBuilder
    public void processBuilder() {
        // making a command list
        List<String> list = new ArrayList<String>();
        list.add("notepad.exe");
        
        ProcessBuilder build = new ProcessBuilder(list);
        // start() command open the notepad
        try {
            System.out.print(build.start());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        // printing environment variable using processBuilder
        //for environment variable
        Map<String, String> environment = build.environment();
        //for printing key
        for (Map.Entry<String, String> s : environment.entrySet()) {
            System.out.println(s.getKey() + "->" + s.getValue());
        }
    }

    // open notepad using runTime
    public void runTime() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("notepad");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        RuntimeTest runtimeTest = new RuntimeTest();
        runtimeTest.processBuilder();
        //  runtimeTest.runTime();
    }
}
