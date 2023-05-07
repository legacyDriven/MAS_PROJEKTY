package org.example.qualifiedAssoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    @DisplayName("Asocjacja kwalifikowana - test dodawania zamówienia do klienta")
    public void testAddOrderToCustomer() {
        // Tworzenie klienta
        Customer customer = new Customer();

        // Tworzenie zamówień
        Order order1 = new Order(customer, 1);
        Order order2 = new Order(customer, 2);

        // Dodawanie zamówień do klienta
        customer.addOrder(1, order1);
        customer.addOrder(2, order2);

        // Sprawdzenie, czy zamówienia zostały dodane do klienta
        Map<Integer, Order> orders = customer.getOrders();
        assertEquals(2, orders.size());
        assertSame(order1, orders.get(1));
        assertSame(order2, orders.get(2));
    }

    @Test
    @DisplayName("Asocjacja kwalifikowana - test usuwania zamówienia z klienta")
    public void testRemoveOrderFromCustomer() {
        // Tworzenie klienta
        Customer customer = new Customer();

        // Tworzenie zamówienia
        Order order1 = new Order(customer, 1);

        // Dodawanie zamówienia do klienta
        customer.addOrder(1, order1);

        // Usuwanie zamówienia z klienta
        customer.removeOrder(1);

        // Sprawdzenie, czy zamówienie zostało usunięte
        Map<Integer, Order> orders = customer.getOrders();
        assertTrue(orders.isEmpty());
    }
}