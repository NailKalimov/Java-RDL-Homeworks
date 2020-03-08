package org.fundamentals.myapplication;

class Mouse extends Pet{

    @Override
    public String getName() {
        return "Mice";
    }

    @Override
    public String getPetsSound() {
        return "squeak-squeak";
    }

    @Override
    public String getPetsProfession() {
        return "nibbling furniture";
    }
}
