package org.fundamentals.myapplication;

class UnknownPet extends Pet {
    private String name;

    public UnknownPet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPetsSound() {
        return "unknown sound";
    }

    @Override
    public String getPetsProfession() {
        return "unknown, that does";
    }
}
