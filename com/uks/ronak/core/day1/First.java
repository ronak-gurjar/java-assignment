package com.uks.ronak.core.day1;

class Message {
    public void greet() {
        System.out.println("welcome to Brickwork");
    }
}

public class First {
    public static void main(String[] args) {
        Message message = new Message();
        message.greet();
    }
}
