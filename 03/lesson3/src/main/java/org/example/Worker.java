package org.example;

public class Worker extends BaseClassForEmployees{

    int salary;


    public Worker(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public Integer calculationSalaryAverage() {
        return this.salary;

    }

    @Override
    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Worker{" +
                "salary=" + salary +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
