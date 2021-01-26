package com.uks.ronak.core.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FormattedNumber {
    public String formattedNumber(String outputFormatType, double num) {
        DecimalFormat decimalFormat = new DecimalFormat(outputFormatType);
        return decimalFormat.format(num);
    }

    public static void main(String[] args) {
        FormattedNumber formattedNumber = new FormattedNumber();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter pattern");
        String pattern = sc.nextLine();
        System.out.println("enter number");
        double num = sc.nextDouble();
        String output = formattedNumber.formattedNumber(pattern, num);
        System.out.println(output);
    }
}