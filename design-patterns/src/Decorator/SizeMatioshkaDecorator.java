package Decorator;

public class SizeMatioshkaDecorator extends MatrioshkaDecorator {
    String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SizeMatioshkaDecorator(AMatrioshka matrioshka, String size) {
        super(matrioshka);
        this.size = size;
    }

    @Override
    public String toString() {
        return matrioshka.toString() + ", size='" + size + "'";
    }
}
