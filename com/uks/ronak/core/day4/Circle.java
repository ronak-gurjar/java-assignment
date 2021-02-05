package com.uks.ronak.core.day4;

import java.util.Scanner;

public class Circle {
    public static final double PI = 3.14;

    public double ariaOfCircle(long radius) {
        return (long) (PI * radius * radius);
    }

    //overloading method
    public double ariaOfCircle(double radius) {
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter choice 1 for long and 2 for double");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("enter long radius");
            long lRadius = scanner.nextLong();
            double longArea = circle.ariaOfCircle(lRadius);
            System.out.println(" area = " + longArea);
        } else if (choice == 2) {
            System.out.println("enter double radius");
            double dRadius = scanner.nextDouble();
            double doubleArea = circle.ariaOfCircle(dRadius);
            System.out.println(" area = " + doubleArea);
        } else {
            System.out.println("wrong input");
        }
    }
}