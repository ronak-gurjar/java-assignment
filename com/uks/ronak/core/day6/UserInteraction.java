package com.uks.ronak.core.day6;

import com.uks.ronak.core.day1.MultiCommandLine;
import com.uks.ronak.core.day2.StringOperation;
import com.uks.ronak.core.day3.CallClassDetails;
import com.uks.ronak.core.day3.CallDateAdd;
import com.uks.ronak.core.day3.DateAndTime;
import com.uks.ronak.core.day3.DateDifference;
import com.uks.ronak.core.day4.FrequencyChecker;
import com.uks.ronak.core.day5.EmpSort;
import com.uks.ronak.core.day5.EmployeeSearch;
import com.uks.ronak.core.day5.RowPrinter;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

class UserInteraction {
    public static void main(String[] args) throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a -> MultiCommandLine");
        System.out.println("b -> StringOperation");
        System.out.println("c -> StringOperation2");
        System.out.println("d -> DateAndTime");
        System.out.println("e -> DateDifferance");
        System.out.println("f -> DateAdd");
        System.out.println("g -> ClassDetails");
        System.out.println("h -> FrequencyChecker");
        System.out.println("i -> EmployeeSearch");
        System.out.println("j -> EmployeeSortedList");
        System.out.println("k -> exit" + "\n");
        while (true) {
            System.out.print("enter your choice -> ");
            String choice;
            try {
                choice = scanner.nextLine();
            } catch (InputMismatchException e) {
                throw new InvalidInputException("invalid input");
            }
            switch (choice) {
                case "a":
                    MultiCommandLine multiCommandLine = new MultiCommandLine();
                    System.out.println("enter 1 for addition or 2 for lowercase");
                    int ch;
                    try {
                        ch = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        throw new InvalidInputException("invalid input");
                    }
                    if (ch < 0) {
                        throw new InvalidInputException("invalid input");
                    } else {
                        multiCommandLine.doOperation(ch);
                    }
                    break;
                case "b":
                    StringOperation stringOperation = new StringOperation();
                    System.out.println("enter string");
                    String string = null;
                    try {
                        string = scanner.nextLine();
                        stringOperation.doOperationWithRegEx(string);
                    } catch (InputMismatchException e) {
                        throw new InvalidInputException("invalid input");
                    }
                    break;
                case "c":
                    StringOperation stringOperation1 = new StringOperation();
                    System.out.println("enter string");
                    String st;
                    try {
                        st = scanner.nextLine();
                        stringOperation1.doOperation(st);
                    } catch (InputMismatchException e) {
                        throw new InvalidInputException("invalid input");
                    }
                    break;
                case "d":
                    DateAndTime dateAndTime = new DateAndTime();
                    System.out.println("enter pattern for format date");
                    String pattern = scanner.nextLine();
                    System.out.println("enter date in this format (\"yyyy/MM/dd\") ");
                    String inputDate = scanner.nextLine();
                    try {
                        dateAndTime.dateTime(pattern, inputDate);
                    } catch (ParseException e) {
                        throw new InvalidInputException("invalid input exception occur");
                    }
                    break;
                case "e":
                    DateDifference dateDifference = new DateDifference();
                    try {
                        System.out.println("enter date 1 [dd/MM/yyyy]");
                        String inputDate1 = scanner.nextLine();
                        System.out.println("enter date 2 [dd/Mm/yyyy]");
                        String inputDate2 = scanner.nextLine();
                        dateDifference.dateDifference(inputDate1, inputDate2);
                    } catch (ParseException e) {
                        throw new InvalidInputException("input is not valid");
                    }
                    break;
                case "f":
                    CallDateAdd callDateAdd = new CallDateAdd();
                    try {
                        System.out.println("input date in this format (\"yyyy/MM/dd\") ");
                        String iDate = scanner.nextLine();
                        System.out.println("enter addType [ month ,day or year ]");
                        String type = scanner.nextLine();
                        System.out.println("enter number to add");
                        int num = 0;
                        try {
                            num = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            throw new InvalidInputException("invalid input");
                        }
                        callDateAdd.dateAdd(iDate, type, num);
                    } catch (ParseException e) {
                        throw new InvalidInputException("input is not valid");
                    }
                    break;
                case "g":
                    CallClassDetails callClassDetails = new CallClassDetails();
                    System.out.println("enter the name of class:[com.uks.ronak.core.dayX.XXXXXXX]");
                    String className = scanner.nextLine();
                    Class cls = null;
                    try {
                        cls = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new InvalidInputException("input is not valid");
                    }
                    if (className.equals(cls.getName())) {
                        System.out.println("enter typeOfInfo[ALL],[M],[F],[C]");
                        String typeOfInfo = scanner.nextLine();
                        try {
                            callClassDetails.classDetails(className, typeOfInfo);
                        } catch (java.lang.ClassNotFoundException e) {
                            throw new InvalidInputException("input is not valid");
                        }

                    } else {
                        System.out.println("class name not match");
                    }
                    break;
                case "h":
                    FrequencyChecker frequencyChecker = new FrequencyChecker();
                    System.out.println("enter the size of array");
                    int size = 0;
                    try {
                        size = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        throw new InvalidInputException("not valid");
                    }
                    scanner.nextLine();
                    String[] str = new String[size];
                    System.out.println("enter the string");
                    for (int i = 0; i < size; i++) {
                        str[i] = scanner.nextLine();
                    }
                    try {
                        frequencyChecker.frequencyChecker(str);
                    } catch (Exception e) {
                        throw new InvalidInputException("invalid input exception");
                    }
                    break;
                case "i":
                    EmployeeSearch employeeSearch = new EmployeeSearch();
                    System.out.println("enter last name for search");
                    String lastName = scanner.nextLine();
                    try {
                        employeeSearch.employeeSearch(lastName);
                    } catch (FileNotFoundException e) {
                        throw new InvalidInputException("input is not valid");
                    }
                    break;
                case "j":
                    EmpSort empSort = new EmpSort();

                    System.out.println("enter collum name [ecode], [fname],[lname],[salary],[etype]");
                    String cName = scanner.nextLine();
                    try {
                        empSort.sortedList(cName);
                        RowPrinter.printTabular(cName);
                    } catch (FileNotFoundException fileNotFoundException) {
                        throw new InvalidInputException("input is not valid");
                    }
                    break;
                case "k":
                    return;
                default:
                    System.out.println("oops...wrong choice");
                    break;
            }
        }
    }
}