package org.example.qualifiedAssoc;

public class Order {
    private int orderNumber;
    private Customer customer;

    public Order(Customer client, int orderNumber) {
        this.customer = client;
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}







