package Decorator;

public class ColoredMatrioshkaDecorator extends MatrioshkaDecorator {
    String color;

    public ColoredMatrioshkaDecorator(AMatrioshka matrioshka, String color) {
        super(matrioshka);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return matrioshka.toString() + ", color='" + color + "'";
    }
}
