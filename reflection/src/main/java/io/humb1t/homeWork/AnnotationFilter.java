package io.humb1t.homeWork;

import org.reflections.Reflections;

import java.util.*;

public class AnnotationFilter {
    Reflections reflections = new Reflections();
    Object[] arrayOfObjects;
    HashMap<Class<?>, Set<Class<?>>> deprecatedClasses = new HashMap<>();

    public AnnotationFilter(Object[] objects) {
        this.arrayOfObjects = objects;
    }

    void startSearchDeprecatedClasses() {
        findDeprecatedClasses(arrayOfObjects);
        System.out.println("Deprecated classes: ");
        deprecatedClasses.keySet().forEach(System.out::println);
        deprecatedClasses.forEach(AnnotationFilter::printRecommendation);
    }

    static void printRecommendation(Class<?> key, Set<Class<?>> set) {
        System.out.println("Вместо класса " + key.getSimpleName() + " рекоммендуется использовать: ");
        set.forEach(o -> System.out.println("-" + o.getName()));
    }

    private void findDeprecatedClasses(Object[] arrayOfObjects) {
        for (Object obj : arrayOfObjects) {
            Class<?> classOfObject = obj.getClass();
            if (classOfObject.isAnnotationPresent(Deprecated.class)) {
                deprecatedClasses.put(classOfObject, getRecommendationsForUsage(classOfObject));
            }
        }
    }

    private Set<Class<?>> getRecommendationsForUsage(Class<?> deprClass) {
        Class<?> superClass = deprClass.getSuperclass();
        Class<?>[] interfaces = deprClass.getInterfaces();
        Set<Class<?>> recommendations = new LinkedHashSet<>();
        if (!superClass.isAnnotationPresent(Deprecated.class) && superClass != Object.class
                && reflections.getSubTypesOf(superClass).size() != 0) {
            for (Class<?> childClass : reflections.getSubTypesOf(superClass)) {
                if (!childClass.isAnnotationPresent(Deprecated.class)) {
                    recommendations.add(childClass);
                }
            }
        }
        for (Class<?> parentInterface : interfaces) {
            for (Class<?> childClass : reflections.getSubTypesOf(parentInterface)) {
                if (!childClass.isAnnotationPresent(Deprecated.class)) {
                    recommendations.add(childClass);
                }
            }
        }
        return recommendations;
    }
}


