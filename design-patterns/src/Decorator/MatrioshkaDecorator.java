package Decorator;

public class MatrioshkaDecorator extends AMatrioshka {
    AMatrioshka matrioshka;

    public MatrioshkaDecorator(AMatrioshka matrioshka) {
        this.matrioshka = matrioshka;
    }

    @Override
    public String toString() {
        return matrioshka.toString();
    }
}
