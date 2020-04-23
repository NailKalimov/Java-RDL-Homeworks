package Factory;

public class Ship implements ITransport {
    IProduct product;

    @Override
    public void answer() {
    }

    @Override
    public void deliver() {
        System.out.println("Доставка по морю.");
    }

    @Override
    public void putProduct(IProduct product) {
        this.product = product;
        System.out.println("Погрузка груза в трюм.");
    }

    @Override
    public IProduct getProduct() {
        return product;
    }
}
