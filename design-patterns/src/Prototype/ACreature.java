package Prototype;

public abstract class ACreature implements ICreature {
    String name; // имя существа
    static int count = 0;

    public ACreature(ACreature creature) {
        count++;
        this.name = creature.name + count;
    }

    public ACreature() {
        count++;
    }

    @Override
    public ICreature clone() {
        return null;
    }
}
