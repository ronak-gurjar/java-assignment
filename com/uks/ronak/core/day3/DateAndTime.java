package com.uks.ronak.core.day3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateAndTime {
    // method
    public void dateTime(String outputFormatType, String date) throws ParseException {
        Date simpleDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outputFormatType);
        System.out.println(simpleDateFormat.format(simpleDate));
    }

    public static void main(String[] args) throws ParseException {
        DateAndTime ob = new DateAndTime();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter pattern for format date");
        String pattern = scanner.nextLine();
        System.out.println("enter [yes] if you want to format specific date");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("enter date in this format (\"yyyy/MM/dd\") ");
            String inputDate = scanner.nextLine();
            ob.dateTime(pattern, inputDate);

        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            //parsing today date in this  yyyy/MM/dd format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            ob.dateTime(pattern, localDateTime.format(formatter));

        }
    }
}
