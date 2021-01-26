package com.uks.ronak.core.day3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.time.Period.between;

public class DateDifference {

    //this is for day6 ass1
    public void dateDifference(String iDate1, String iDate2) throws ParseException {

        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(iDate1);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(iDate2);
        long timeDiff;
        if (date1.after(date2)) {
            timeDiff = date1.getTime() - date2.getTime();
        } else {
            timeDiff = date2.getTime() - date1.getTime();
        }
        long difference = (timeDiff / (1000 * 60 * 60 * 24));
        System.out.println("number of day difference =>" + difference);
    }

    public static void main(String[] args) throws ParseException {
        DateDifference dateDifference = new DateDifference();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter date 1 [dd/MM/yyyy]");
        String inputDate1 = scanner.nextLine();
        System.out.println("enter date 2 [dd/Mm/yyyy]");
        String inputDate2 = scanner.nextLine();
        dateDifference.dateDifference(inputDate1, inputDate2);
    }
}
