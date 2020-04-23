package io.humb1t.homeWork;

class ParentClass implements InterfaceForMyClasses {
    static boolean isAnnotated = false;

    @Override
    public void doSomeThing() {
        System.out.println("Этот класс имплементирует InterfaceForMyClasses");
    }
}
