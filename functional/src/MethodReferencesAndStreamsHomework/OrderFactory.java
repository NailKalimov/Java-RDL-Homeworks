package MethodReferencesAndStreamsHomework;

public interface OrderFactory {

    default Order createCompletedOrder() {
        return new Order(OrderStatus.COMPLETED);
    }

    default Order createProcessingOrder() {
        return new Order(OrderStatus.PROCESSING);
    }

    default Order createNonStartedOrder() {
        return new Order(OrderStatus.NOT_STARTED);
    }
}
