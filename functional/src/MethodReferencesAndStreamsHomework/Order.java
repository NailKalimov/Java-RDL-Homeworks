package MethodReferencesAndStreamsHomework;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public OrderStatus status;
    public double price;

    public Order(OrderStatus status) {
        this.status = status;
        this.price = getRandomPrice();
    }

    public boolean priceInOrderMoreThan(int threshold) {
        return this.price > threshold;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", price=" + price +
                '}';
    }

    static List<Order> generateListOfOrders(int size) {
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < size / 3; i++) {
            list.add(new Order(OrderStatus.COMPLETED));
        }
        for (int i = 0; i < size / 3; i++) {
            list.add(new Order(OrderStatus.PROCESSING));
        }
        for (int i = 0; i < size / 3; i++) {
            list.add(new Order(OrderStatus.NOT_STARTED));
        }
        return list;
    }

    private static double getRandomPrice() {
        int MIN_PRICE = 0;
        int MAX_PRICE = 1000;
        return (Math.random() * (MAX_PRICE - MIN_PRICE)) + MIN_PRICE;
    }
}

