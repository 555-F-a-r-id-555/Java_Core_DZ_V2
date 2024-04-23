package org.example;

public class Freelancer extends BaseClassForEmployees {

    int workTime;
    int hourlyRate;

    public Freelancer(String name, int age,int workTime,int hourlyRate) {
        super(name, age);
        this.workTime = workTime;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public Integer calculationSalaryAverage() {

        return (int)(20.8 * workTime * hourlyRate);
    }

    @Override
    public int getSalary() {
        return calculationSalaryAverage();
    }



    @Override
    public String toString() {
        return "Freelancer{" +
                "salary=" + getSalary() +
                ", workTime=" + workTime +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
