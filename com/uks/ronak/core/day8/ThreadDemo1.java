package com.uks.ronak.core.day8;

public class ThreadDemo1 extends Thread {
    public void run() {

        for (int i = 1; i <= 5000; i++) {
            System.out.println(Thread.currentThread().getName() + "=> " + i);
            if (i % 50 == 0) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        // for runnable interface
        Thread thread = new Thread(threadDemo2);
        threadDemo1.start();
        thread.start();
    }
}
