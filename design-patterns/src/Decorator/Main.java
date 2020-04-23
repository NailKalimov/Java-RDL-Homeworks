package Decorator;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        AMatrioshka matrioshka = new Matrioshka("Masha");
        AMatrioshka blueMatrioshka = new ColoredMatrioshkaDecorator(matrioshka, "blue");
        AMatrioshka redMartioshka = new ColoredMatrioshkaDecorator(matrioshka, "red");
        AMatrioshka violetMatrioshka = new ColoredMatrioshkaDecorator(matrioshka, "violet");
        AMatrioshka bigRedMatrioshka = new SizeMatioshkaDecorator(redMartioshka, "big");
        AMatrioshka bigGreenMatrioshka = new SizeMatioshkaDecorator(new ColoredMatrioshkaDecorator(matrioshka, "green"), "big");

        Stream.of(matrioshka, blueMatrioshka, redMartioshka, violetMatrioshka, bigRedMatrioshka, bigGreenMatrioshka)
                .forEach(System.out::println);
    }
}
