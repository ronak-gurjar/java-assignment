package com.uks.ronak.core.day5;

import java.util.Comparator;

class Salary implements Comparator<EmployeeSortedList> {

    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return (int) (o1.getBasicSalary() - o2.getBasicSalary());
    }
}
