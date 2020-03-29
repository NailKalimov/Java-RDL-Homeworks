package Factory;

public class Main {
    public static void main(String[] args) {
        Logistics logistic = new SeaLogistic();
        logistic.deliver(new Rum());
    }
}
