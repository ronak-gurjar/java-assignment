package com.uks.ronak.core.day5;

import java.util.Comparator;

class EType implements Comparator<EmployeeSortedList> {
    @Override
    public int compare(EmployeeSortedList o1, EmployeeSortedList o2) {
        return o1.getEmpType().compareTo(o2.getEmpType());
    }
}
