package Prototype;

public class Main {
    public static void main(String[] args) {
        Planet planet = new Planet();
        Creature creature = new Creature();
        creature.name = "human";
        planet.creatures.add(creature);
        for (int i = 0; i < 50; i++) {
            planet.creatures.add(creature.clone());
        }
        planet.creatures.stream().map(ICreature::getName).forEach(System.out::println);
    }
}
