package org.fundamentals.myapplication;

class Dog extends Pet {
    @Override
    public String getName() {
        return "Dog";
    }

    @Override
    public String getPetsSound() {
        return "woof";
    }

    @Override
    public String getPetsProfession() {
        return "protect house";
    }
}
