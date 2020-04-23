package io.humb1t.homeWork;

public class SecondNotAnnotatedClass extends ParentClass implements InterfaceForMyClasses {

    @Override
    public void doSomeThing() {
        System.out.println("Этот класс имплементирует InterfaceForMyClasses");
    }
}

