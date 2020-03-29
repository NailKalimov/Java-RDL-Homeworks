package Factory;

public class Truck implements ITransport {
    IProduct product;

    @Override
    public void answer() {
    }

    @Override
    public void deliver() {
        System.out.println("Доставка по дороге.");
    }

    @Override
    public void putProduct(IProduct product) {
        System.out.println("Загрузка груза в кузов.");
    }

    @Override
    public IProduct getProduct() {
        return product;
    }
}
