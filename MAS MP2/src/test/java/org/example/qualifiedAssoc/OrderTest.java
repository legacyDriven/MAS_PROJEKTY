package org.example.qualifiedAssoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("Test tworzenia zamówienia z właściwościami")
    public void testOrderCreation() {
        // Tworzenie klienta
        Customer customer = new Customer();

        // Tworzenie zamówienia z podanymi właściwościami
        Order order = new Order(customer, 1);

        // Sprawdzenie, czy właściwości zamówienia są ustawione prawidłowo
        assertSame(customer, order.getCustomer());
        assertEquals(1, order.getOrderNumber());
    }

    @Test
    @DisplayName("Test zmiany właściwości zamówienia")
    public void testOrderSetters() {
        // Tworzenie klienta
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // Tworzenie zamówienia
        Order order = new Order(customer1, 1);

        // Zmiana właściwości zamówienia
        order.setCustomer(customer2);
        order.setOrderNumber(2);

        // Sprawdzenie, czy właściwości zamówienia zostały zmienione
        assertSame(customer2, order.getCustomer());
        assertEquals(2, order.getOrderNumber());
    }
}