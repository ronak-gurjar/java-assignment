package com.uks.ronak.core.day7;

import java.io.Serializable;

public class EmployeeDetail implements Serializable {

    String name;
    byte age;
    long basicSalary;

    public EmployeeDetail(String name, byte age, long basicSalary) {
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public long getBasicSalary() {
        return basicSalary;
    }
}