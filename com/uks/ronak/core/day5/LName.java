package com.uks.ronak.core.day5;

import java.util.Comparator;

class LName implements Comparator<EmployeeSortedList> {

    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
