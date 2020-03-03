package org.fundamentals.myapplication;

class Cat extends Pet {

    @Override
    public String getName() {
        return "Cat";
    }

    @Override
    public String getPetsSound() {
        return "meow";
    }

    @Override
    public String getPetsProfession() {
        return "catch mice";
    }
}
