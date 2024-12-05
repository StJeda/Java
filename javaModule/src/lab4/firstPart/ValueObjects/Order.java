package lab4.firstPart.ValueObjects;

import java.util.Date;

public record Order(String productName, String deliveryAddress, double unitPrice, int quantity, boolean isPrepaid, Date orderDate) { }
