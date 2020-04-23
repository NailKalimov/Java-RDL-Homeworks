package Prototype;

import java.util.ArrayList;

public class Planet extends APlanet {
    public Planet() {
        this.creatures = new ArrayList<>();
    }

    @Override
    public void addCreature(ICreature creature) {
        creatures.add(creature);
    }

    @Override
    public long getPopulation() {
        return creatures.size();
    }
}
