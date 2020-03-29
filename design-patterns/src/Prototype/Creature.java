package Prototype;

public class Creature extends ACreature {

    public Creature(ACreature creature) {
        super(creature);
    }

    public Creature() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ICreature clone() {
        return new Creature(this);
    }
}
