package MethodReferencesAndStreamsHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static MethodReferencesAndStreamsHomework.Order.generateListOfOrders;

public class Main {
    public static void main(String[] args) {
        List<Order> listOfOrders = generateListOfOrders(60);
        listOfOrders = listOfOrders.stream().filter(order -> order.priceInOrderMoreThan(800))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listOfOrders.toString());
    }
}
