package com.uks.ronak.core.day3;

import java.text.ParseException;
import java.util.Scanner;

public class CallDateAdd extends DateAdd {
    public static void main(String[] args) throws ParseException {
        CallDateAdd callDateAdd = new CallDateAdd();
        Scanner scanner = new Scanner(System.in);

        System.out.println("input date in this format (\"yyyy/MM/dd\") ");
        String iDate = scanner.nextLine();

        System.out.println("enter addType [ month ,day or year ]");
        String type = scanner.nextLine();

        System.out.println("enter number to add");
        int num = scanner.nextInt();

        callDateAdd.dateAdd(iDate, type, num);
    }
}
