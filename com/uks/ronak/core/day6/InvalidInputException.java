package com.uks.ronak.core.day6;

public class InvalidInputException extends Throwable {
    String message;

    public InvalidInputException(String str) {
        this.message = str;
    }
    @Override// this is Throwable class override method
    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        try {
            throw new InvalidInputException("invalid input exception occur");
        } catch (InvalidInputException invalidInputException) {
            System.out.println(invalidInputException);
            invalidInputException.printStackTrace();
        }
    }
}