package com.uks.ronak.core.day8;

class ThreadDemo2 implements Runnable {
    public void run() {

        for (int i = 1; i <= 5000; i++) {
            System.out.println(Thread.currentThread().getName() + "=> " + i);
            if (i % 75 == 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
