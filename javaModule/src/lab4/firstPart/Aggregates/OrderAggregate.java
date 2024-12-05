package lab4.firstPart.Aggregates;

import lab4.firstPart.ValueObjects.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderAggregate {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getPrepaidOrders() {
        return orders.stream()
                .filter(Order::isPrepaid)
                .collect(Collectors.toList());
    }

    public List<Order> getUnpaidOrders() {
        return orders.stream()
                .filter(order -> !order.isPrepaid())
                .collect(Collectors.toList());
    }

    public List<Order> searchByAddress(String addressPart) {
        return orders.stream()
                .filter(order -> order.deliveryAddress().toLowerCase().contains(addressPart.toLowerCase()))
                .collect(Collectors.toList());
    }
}
