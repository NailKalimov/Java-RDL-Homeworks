package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Task4 {
    static Collection<Double> list = initialiseListWithDuplicate();

    public static void main(String[] args) {
        System.out.println("Коллекция с дублирующимися элементами: ");
        list.forEach(System.out::println);
        list = list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Коллекция без дублирующихся элементов: ");
        list.forEach(System.out::println);
    }

    static Collection<Double> initialiseListWithDuplicate(){
        Collection<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Math.random() * 10);
            if (i==2){
                for (int j = 0; j < 5; j++) {
                    list.add(10.0);
                }
            }
        }
        return list;
    }
}

