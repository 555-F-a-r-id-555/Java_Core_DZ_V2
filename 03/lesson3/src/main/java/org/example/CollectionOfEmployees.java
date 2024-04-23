package org.example;

import java.util.ArrayList;

public class CollectionOfEmployees {


    public ArrayList<BaseClassForEmployees> createCollection() {
        Freelancer freelancer$1 = new Freelancer("Дима", 20, 4, 1_000);
        Freelancer freelancer$2 = new Freelancer("Коля", 30, 6, 1_500);
        Freelancer freelancer$3 = new Freelancer("Маша", 24, 3, 1_100);

        Worker worker$1 = new Worker("Саша", 26, 50_000);
        Worker worker$2 = new Worker("Оля", 25, 70_000);
        Worker worker$3 = new Worker("Влад", 32, 90_000);

        ArrayList<BaseClassForEmployees> arrayList = new ArrayList<>();
        arrayList.add(freelancer$1);
        arrayList.add(freelancer$2);
        arrayList.add(freelancer$3);

        arrayList.add(worker$1);
        arrayList.add(worker$2);
        arrayList.add(worker$3);



        return arrayList;
    }



}


//        BaseClassForEmployees[] array = new BaseClassForEmployees[]{freelancer$1,
//                freelancer$1,
//                freelancer$2,
//                freelancer$3,
//                worker$1,
//                worker$2,
//                worker$3};
//
//
//        Collections.addAll(arrayList, array);
//        System.out.println(arrayList.size());