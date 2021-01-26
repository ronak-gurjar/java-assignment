package com.uks.ronak.core.day2;

import java.util.Scanner;

class CheckForVowel {
    public void checkChar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1=>vowel");
        System.out.println("2=>constant");
        System.out.print("enter choice=");
        int choice = sc.nextInt();
        System.out.print("enter character=");
        char ch = sc.next().charAt(0);

        switch (choice) {
            case 1:
                if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
                    System.out.println("it is vowel");
                    break;
                }
            case 2:
                if (ch != 'a' || ch != 'A' || ch != 'e' || ch != 'E' || ch != 'i' || ch != 'I' || ch != 'o' || ch != 'O' || ch != 'u' || ch != 'U') {
                    System.out.println("it is constant");
                    break;
                }
            default:
                System.out.println("enter valid choise");
        }
    }
}

public class VowelConstant {
    public static void main(String[] args) {
        CheckForVowel ob = new CheckForVowel();
        ob.checkChar();

    }
}
