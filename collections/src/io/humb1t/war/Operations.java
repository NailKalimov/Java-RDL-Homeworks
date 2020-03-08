package io.humb1t.war;

import java.util.ArrayList;
import java.util.Vector;

import static java.lang.System.currentTimeMillis;

public class Operations {
    static long startTime;
    static long finishTime;
    static long time;

    static Vector<Integer> vector = new Vector<>();
    static ArrayList<Integer> arrayList = new ArrayList<>();

    static void testWrite(){
        startTime = currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        finishTime = currentTimeMillis();
        time = finishTime - startTime;
        System.out.println("Время записи 100000 элементов в Vector: " + time + "мс");
        startTime = currentTimeMillis();
        for (int i = 0; i <100000; i++) {
            arrayList.add(i);
        }
        finishTime = currentTimeMillis();
        time = finishTime - startTime;
        System.out.println("Время записи 100000 элементов в ArrayList: " + time + "мс");
    }
    static void testRead(){
        Integer a;
        startTime = currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a=vector.elementAt(i);
        }
        finishTime = currentTimeMillis();
        time = finishTime - startTime;
        System.out.println("Время возврата 100000 элементов из Vector по индексу: " + time + "мс");
        startTime = currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a=arrayList .get(i);

        }
        finishTime = currentTimeMillis();
        time = finishTime - startTime;
        System.out.println("Время возврата 100000 элементов из ArrayList по индексу: " + time + "мс");
    }
    static void testDelete(){
        startTime = currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            vector.remove(0);
        }
        finishTime = currentTimeMillis();
        time = finishTime - startTime;
        System.out.println("Время удаления 100000 элементов из Vector по индексу: " + time + "мс");
        startTime = currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList .remove(0);

        }
        finishTime = currentTimeMillis();
        time = finishTime - startTime;
        System.out.println("Время удаления 100000 элементов из ArrayList по индексу: " + time + "мс");
    }
}
