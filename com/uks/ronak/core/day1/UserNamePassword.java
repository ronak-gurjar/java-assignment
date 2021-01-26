package com.uks.ronak.core.day1;

import java.util.Scanner;

public class UserNamePassword {
    // hard coded values
    String userName = "ronak";
    int userPassword = 1234;

    public void validate(String inputName, int inputPassword) {
        if (inputName.equals(userName) && inputPassword == userPassword) {
            System.out.println("it is valid");
        } else {
            System.out.println("not valid");
        }
    }
    public static void main(String[] args) {
        UserNamePassword userNamePassword = new UserNamePassword();
       // userNamePassword.validate("ronak", 124);
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter name");
        String userName= scanner.nextLine();
        System.out.println("enter password");
        int password = scanner.nextInt();
        userNamePassword.validate(userName,password);
    }
}