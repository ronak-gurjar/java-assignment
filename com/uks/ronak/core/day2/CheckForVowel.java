package com.uks.ronak.core.day2;

import java.util.Scanner;

public class CheckForVowel {
    public static void main(String[] args) {
            VowelConstant vowelConstant= new VowelConstant();
            Scanner scanner = new Scanner(System.in);

            System.out.print("enter character=");
            char ch = scanner.next().charAt(0);
            vowelConstant.checkChar(ch);

        }
    }

