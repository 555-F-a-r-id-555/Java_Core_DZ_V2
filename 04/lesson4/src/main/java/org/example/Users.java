package org.example;


import java.util.ArrayList;

public class Users {
    private String name;
    private int age;
    private String phone;

    private int salary;

//    private ArrayList<Account> accountList;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public Users(String name, int age, String phone, int salary) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.salary = salary;
    }

//    public Users(String name, int age, String phone, int salary, ArrayList<Account> accountList) {
//        this.name = name;
//        this.age = age;
//        this.phone = phone;
//        this.salary = salary;
//        this.accountList = accountList;
//    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
//                ", accountList=" + accountList.toString() +
                '}';
    }
}

