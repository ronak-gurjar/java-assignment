package com.uks.ronak.core.day3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ClassDetails {

    //constructor
    public ClassDetails() {
        System.out.println("i am constructor");
    }

    //print methods
    public void printMethod(Class cls) {
        Method[] methods = cls.getMethods();
        for (Method method : methods)
            System.out.println(method.getName());
    }

    // print fields
    public void printField(Class cls) {
        Field[] fields = cls.getFields();
        for (Field field : fields)
            System.out.println(field.getName());
    }

    public void printConstructor(Class cls) {
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors)
            System.out.println(constructor.getName());
    }

    // this is for day 6 ass1
    public void classDetails(String cname, String info) throws ClassNotFoundException {
        Class cls = Class.forName(cname);
        switch (info) {
            //printing method name
            case "M":
                try {
                    this.printMethod(cls);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            // printing field
            case "F":
                try {
                    this.printField(cls);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            case "C":
                try {
                    this.printConstructor(cls);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;

            case "ALL":
                try {
                    this.printMethod(cls);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                try {
                    this.printField(cls);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            default:
                System.out.println("enter valid input");
        }
    }

    public static void main(String[] args) throws Exception {

    }
}