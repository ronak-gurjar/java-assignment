package com.uks.ronak.core.day5;

import java.util.Comparator;

class FName implements Comparator<EmployeeSortedList> {

    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
