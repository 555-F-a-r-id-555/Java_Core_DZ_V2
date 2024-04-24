package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CollectionOfEmployees {


    public ArrayList<BaseClassForEmployees> createCollection() {
        Freelancer freelancer$1 = new Freelancer("Дима", 20, 4, 1_000);
        Freelancer freelancer$2 = new Freelancer("Коля", 30, 6, 1_500);
        Freelancer freelancer$3 = new Freelancer("Маша", 24, 3, 1_100);

        Worker worker$1 = new Worker("Саша", 26, 50_000);
        Worker worker$2 = new Worker("Оля", 25, 70_000);
        Worker worker$3 = new Worker("Влад", 32, 90_000);

        ArrayList<BaseClassForEmployees> arrayList = new ArrayList<>();


        Collections.addAll(arrayList,
                freelancer$1,
                freelancer$2,
                freelancer$3,
                worker$1,
                worker$2,
                worker$3);


        Random random = new Random();

        // Freelancer
//        for (int i = 0; i < 3; i++) {
//            String name = "Freelancer " + (i + 1);
//            int age = random.nextInt(40) + 20; // возраст от 20 до 59 лет
//            int experience = random.nextInt(10) + 1; // время работы от 1 до 8 часов
//            int salary = random.nextInt(2000) + 1000; // заработная плата от 1000 до 2999
//            arrayList.add(new Freelancer(name, age, experience, salary));
//        }

        // Worker
//        for (int i = 0; i < 3; i++) {
//            String name = "Worker " + (i + 1);
//            int age = random.nextInt(40) + 20; // возраст от 20 до 59 лет
//            int salary = random.nextInt(90000) + 10000; // заработная плата от 10000 до 99999
//            arrayList.add(new Worker(name, age, salary));
//        }

        return arrayList;
    }


}
