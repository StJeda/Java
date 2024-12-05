package lab4.firstPart.Listing;

import lab4.firstPart.Aggregates.OrderAggregate;
import lab4.firstPart.ValueObjects.Order;
import java.util.Date;
import static java.lang.System.out;

class Main {
    public static void main() {
        var manager = new OrderAggregate();

        manager.addOrder(new Order("Laptop", "123 Main Street", 1200.0, 1, true, new Date()));
        manager.addOrder(new Order("Phone", "456 Elm Street", 800.0, 2, false, new Date()));
        manager.addOrder(new Order("Tablet", "123 Main Avenue", 400.0, 1, true, new Date()));

        out.println("Prepaid Orders:");
        manager.getPrepaidOrders().forEach(out::println);

        out.println("\nUnpaid Orders:");
        manager.getUnpaidOrders().forEach(out::println);

        out.println("\nOrders with 'Main':");
        manager.searchByAddress("Main").forEach(out::println);
    }
}