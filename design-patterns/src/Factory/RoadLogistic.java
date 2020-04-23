package Factory;

public class RoadLogistic extends Logistics {
    @Override
    ITransport createTransport() {
        return new Truck();
    }
}
