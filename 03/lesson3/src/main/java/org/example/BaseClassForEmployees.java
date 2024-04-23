package org.example;

public  abstract class BaseClassForEmployees {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public BaseClassForEmployees(String name, int age) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Некорректное имя: " + name);
        }

        if (isValidAge(age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Некорректный возраст: " + age);
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.trim().length() > 2;  // !name.trim().isEmpty();
    }

    private boolean isValidAge(int age) {
        return age >= 0 && age <= 150;
    }


    public abstract Integer calculationSalaryAverage();

    public abstract int getSalary();


    @Override
    public String toString() {
        return "BaseClassForEmployees{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
