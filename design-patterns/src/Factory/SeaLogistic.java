package Factory;

public class SeaLogistic extends Logistics {
    @Override
    ITransport createTransport() {
        return new Ship();
    }
}
