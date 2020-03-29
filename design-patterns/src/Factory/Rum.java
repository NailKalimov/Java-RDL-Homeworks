package Factory;

public class Rum implements IProduct {
    @Override
    public void getWeight() {
        System.out.println(1000 + "литров рома(~1000кг)");
    }

    @Override
    public void getSize() {
        System.out.println("1м. x 1.6м. x 2.1м.");
    }
}
