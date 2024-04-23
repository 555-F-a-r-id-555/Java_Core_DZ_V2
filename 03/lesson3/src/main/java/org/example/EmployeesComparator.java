package org.example;

import java.util.Comparator;

class EmployeesComparator implements Comparator<BaseClassForEmployees> {
    @Override
    public int compare(BaseClassForEmployees emp1, BaseClassForEmployees emp2) {
        return Integer.compare(emp1.getSalary(), emp2.getSalary());
    }
}
