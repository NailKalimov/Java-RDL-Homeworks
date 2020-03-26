package io.humb1t.homeWork;

import java.util.Objects;

@Deprecated
class SecondDeprecatedClass implements InterfaceForMyClasses {
    static boolean isAnnotated = false;

    @Override
    public void doSomeThing() {
        System.out.println("Этот класс имплементирует InterfaceForMyClasses");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass().getName());
    }
}
