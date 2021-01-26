package com.uks.ronak.core.day3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAdd {
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String YEAR = "year";


    public void dateAdd(String inputDate, String addType, int number) throws ParseException {
        Date simpleDate = new SimpleDateFormat("yyyy/MM/dd").parse(inputDate);
        // create calendar instance
        Calendar cal = Calendar.getInstance();
        cal.setTime(simpleDate);
        switch (addType) {
            // for add months
            case MONTH:
                System.out.println("before : " + simpleDate);
                cal.add(Calendar.MONTH, number);
                Date newDateMonth = cal.getTime();
                System.out.println("after : " + newDateMonth);
                break;
            // for add days
            case DAY:
                System.out.println("before : " + simpleDate);
                cal.add(Calendar.DATE, number);
                Date newDateDay = cal.getTime();
                System.out.println("after : " + newDateDay);
                break;
            // for add year
            case YEAR:
                System.out.println("before : " + simpleDate);
                cal.add(Calendar.YEAR, number);
                Date newDateYear = cal.getTime();
                System.out.println("after : " + newDateYear);
                break;
            default:
                System.out.println("wrong addType");
        }
    }
    public static void main(String[] args) throws Exception {

    }
}