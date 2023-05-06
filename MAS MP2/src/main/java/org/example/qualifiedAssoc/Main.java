package org.example.qualifiedAssoc;

public class Main {
    public static void main(String[] args) {
        Customer theOne = new Customer();

        Order order1 = new Order(theOne, 1);
        Order order2 = new Order(theOne, 2);

        theOne.addOrder(order1.getOrderNumber(), order1);
        theOne.addOrder(order2.getOrderNumber(), order2);

        System.out.println("Client has " + theOne.getOrders().size() + " orders.");

        theOne.removeOrder(1);

        System.out.println("Client has " + theOne.getOrders().size() + " orders.");
    }
}
