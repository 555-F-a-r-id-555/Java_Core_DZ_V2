package org.example;

import java.util.ArrayList;
import java.util.Iterator;


public class EmployeeIterator implements Iterator<BaseClassForEmployees> {

    private int index = 0;
    private ArrayList<BaseClassForEmployees> arr;

    public EmployeeIterator(ArrayList<BaseClassForEmployees> arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return index < arr.size();
    }

    @Override
    public BaseClassForEmployees next() {
        return arr.get(index++);
    }



    // Метод remove() необходимо реализовать, так как Iterator его требует
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}