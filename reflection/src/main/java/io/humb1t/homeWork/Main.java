package io.humb1t.homeWork;

public class Main {
    public static void main(String[] args) {
        Object[] objects = new Object[]{new FirstDeprecatedClass(), new FirstDeprecatedClass(),
                new FirstNotAnnotationClass(), new ParentClass(), new SecondDeprecatedClass(), new SecondNotAnnotatedClass()};

        AnnotationFilter filter = new AnnotationFilter(objects);

        filter.startSearchDeprecatedClasses();
    }
}
