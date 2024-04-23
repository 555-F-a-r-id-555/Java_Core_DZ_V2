package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeCheckout implements EmployeeSorting {


    CollectionOfEmployees collectionOfEmployees = new CollectionOfEmployees();
    ArrayList<BaseClassForEmployees> list = collectionOfEmployees.createCollection();

     private EmployeeIterator iterator = new EmployeeIterator(list);

    public  void iterateOfEmployees(){
        // Перебирайте элементы, используя итератор
        while (iterator.hasNext()) {
            BaseClassForEmployees employee = iterator.next();
            System.out.println(employee);
        }
    }


    @Override
    public void sortedBySalary() {
//        for (BaseClassForEmployees employee : list) {
//            System.out.println(employee.getName() + "/" + employee.getAge() + " = " + employee.getSalary());
//        }
        //- Либо так V2--работает без класса EmployeesComparator---------------------------------------------------------->
//        list.sort(new Comparator<BaseClassForEmployees>() {
//            @Override
//            public int compare(BaseClassForEmployees o1, BaseClassForEmployees o2) {
//                if (o1.getSalary() > o2.getSalary()) return 1;
//                if (o1.getSalary() < o2.getSalary()) return -1;
//                return 0;
//            }
//        });

        // Либо так V3 -------------------------------------------------------------->
        Collections.sort(list, new EmployeesComparator()); //== list.sort(new SalaryComparator());

        System.out.println("Sorted by salary---------------------------->");

        for (BaseClassForEmployees employee : list) {
            System.out.println(employee.getName() + "/" + employee.getAge() + " = " + employee.getSalary());
        }

        System.out.println("Iteration of sorted salary--------------------------->");
        iterator = new EmployeeIterator(list); // просто для примера
        iterateOfEmployees();


    }

    @Override
    public void sortedByAge() {

        // Либо так V2---работает без класса EmployeesComparator------------------------------------------------------------------->
//        list.sort((o1, o2) -> {
//            if (o1.getAge() > o2.getAge()) return 1;
//            if (o1.getAge() < o2.getAge()) return -1;
//            return 0;
//        });

        // Либо так V3---------------------------------------------------------------------->

        list.sort(Comparator.comparingInt(BaseClassForEmployees::getAge));


        System.out.println("Sorted by age---------------------------->");

        for (BaseClassForEmployees employee : list) {
            System.out.println(employee.getName() + "/" + employee.getAge() + " = " + employee.getSalary());
        }

        System.out.println("Iteration of sorted age--------------------------->");
        iterator = new EmployeeIterator(list); // для примера
        iterateOfEmployees();
    }

    // Сортировка по имени
    @Override
    public void sortedByName() {
        Collections.sort(list, Comparator.comparing(BaseClassForEmployees::getName));

        System.out.println("Sorted by name---------------------------->");

        for (BaseClassForEmployees employee : list) {
            System.out.println(employee.getName() + "/" + employee.getAge() + " = " + employee.getSalary());
        }

        System.out.println("Iteration of sorted name--------------------------->");
        iterator = new EmployeeIterator(list);
        iterateOfEmployees();
    }


}
