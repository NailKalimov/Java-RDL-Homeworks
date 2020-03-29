package Decorator;

public class Matrioshka extends AMatrioshka {

    public Matrioshka(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Matrioshka:" +
                "name='" + name + "'";
    }

}
