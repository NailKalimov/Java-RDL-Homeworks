package Factory;

public abstract class Logistics {
    void deliver(IProduct product) {
        ITransport transport = createTransport();
        transport.putProduct(product);
        transport.deliver();
    }

    abstract ITransport createTransport();
}
