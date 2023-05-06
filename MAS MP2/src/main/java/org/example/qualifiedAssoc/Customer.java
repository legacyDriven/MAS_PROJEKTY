package org.example.qualifiedAssoc;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Getter
@ToString
public class Customer {
    private Map<Integer, Order> orders;

    public Customer() {
        orders = new HashMap<>();
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void addOrder(int orderNumber, Order order) {
        orders.put(orderNumber, order);
    }

    public void removeOrder(int orderNumber) {
        orders.remove(orderNumber);
    }
}