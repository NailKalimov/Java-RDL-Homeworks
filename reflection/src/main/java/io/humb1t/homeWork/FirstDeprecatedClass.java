package io.humb1t.homeWork;

import java.util.Objects;

@Deprecated
public class FirstDeprecatedClass extends ParentClass {
    static boolean isAnnotated = true;

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass().getName());
    }
}