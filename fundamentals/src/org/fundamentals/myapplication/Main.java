package org.fundamentals.myapplication;

public class Main {
	
    public static void main(String[] args) {
        printPetDescription(getPetByName(args[0]));
    }
	
    private static Pet getPetByName(String name) {
        switch (name.toLowerCase()) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            case "hedgehog":
                return new Hedgehog();
            case "mouse":
                return new Mouse();
            default:
                return new UnknownPet(name);
        }
    }
	
    private static void printPetDescription(Pet pet) {
        System.out.println(getDescription(pet));
    }
	
    private static String getDescription(Pet pet){
        return pet.getName() + " says " + pet.getPetsSound() + " and " + pet.getPetsProfession();
    }
}