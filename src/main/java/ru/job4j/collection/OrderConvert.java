package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Dress1"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        for (Map.Entry<String, Order> entry : map.entrySet()) {
            String value = entry.getValue().toString();
            System.out.println(value);
        }
    }
}