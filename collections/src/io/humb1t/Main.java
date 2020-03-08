package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
//        Collection<String> c = Collections.EMPTY_LIST;
//        List<String> list = new ArrayList<>(c);

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            orders.add(new Order(OrderStatus.COMPLETED));
        }
        orders = orders.stream()
                .filter(order -> order.price >= 500).collect(Collectors.toCollection(ArrayList::new));
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        System.out.println("Sorting using Iterator<Order>: ");
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();){
            System.out.println(iterator.next().toString());
        }
        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }


    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final OrderStatus status;
        public double price;

        public Order(OrderStatus status) {
            this.status = status;
            this.price = getRandomPrice();
        }

        public OrderStatus getStatus() {
            return status;
        }

        public String toString(){
            return "OrderStatus: " + status.toString() + " Prise: " + price;
        }
    }

    static double getRandomPrice(){
        int MIN_PRICE=0;
        int MAX_PRICE=1000;
        return (Math.random() * (MAX_PRICE - MIN_PRICE)) + MIN_PRICE;
    }
}
