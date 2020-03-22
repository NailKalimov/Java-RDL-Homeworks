package io.humb1t.homeWork;


import java.util.ArrayList;
import java.util.Arrays;

public class AnnotationFilter {
    public static void main(String[] args) {
        Object[] objects = {new FirstDeprecatedClass(), new FirstNotAnnotatedClass(), new SecondNotAnnotatedClass()};
        ArrayList<Object> deprecatedObjects = new ArrayList<>();

        for (Object object : objects) {
            if (object.getClass().isAnnotationPresent(Deprecated.class)) {
                deprecatedObjects.add(object);
                if (!object.getClass().getSuperclass().isAnnotationPresent(Deprecated.class)) {
                    System.out.println("Вместо использования класса " + object.getClass().getSimpleName() +
                            " рекомендуется использовать его родительский класс: " +
                            object.getClass().getSuperclass().getName() + ", т.к. он не помечен @Deprecated");
                } else if (object.getClass().getInterfaces().length != 0) {
                    System.out.print("Интерфейсы класса " + object.getClass().getSimpleName() + " помеченного @Deprecated:");
                    Arrays.stream(object.getClass().getInterfaces()).forEach(System.out::println);
                }
            }
        }
        System.out.print("Массив объектов, помеченных @Deprecated: ");
        deprecatedObjects.forEach(o -> System.out.println(o.toString()));
    }
}


