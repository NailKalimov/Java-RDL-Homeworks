package Prototype;

public abstract class ACreature implements ICreature {
    String Name; // имя существа

    @Override
    public ICreature clone() {
        return null;
    }
}
