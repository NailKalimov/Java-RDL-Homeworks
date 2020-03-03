package org.fundamentals.myapplication;

class Hedgehog extends Pet {
    @Override
    public String getName() {
        return "Hedgehog";
    }

    @Override
    public String getPetsSound() {
        return "frr";
    }

    @Override
    public String getPetsProfession() {
        return "looks cute";
    }
}
