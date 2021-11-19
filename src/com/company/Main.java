package com.company;

//Simulate a McDonalds Drive. Drivers (threads) submit requests at a waiting queue.
//A request contains the list of products the driver wants and a generated id. Cooks take requests from the waiting queue and create orders. 
//An order contains the list of products from the waiter. Cooks put the orders in the second waiting queue. 
//Waiters take the orders from the waiting queue and print on screen “order containing <list of products> was delivered”.
public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        Driver d1 = new Driver("John",order); d1.start();
        Cook cook1 = new Cook("Cook1", order); cook1.start();
        Cook cook2 = new Cook("Cook2", order); cook2.start();
        Cook cook3 = new Cook("Cook3", order); cook3.start();
        Waiter waiter1 = new Waiter("Waiter1", order); waiter1.start();
        Waiter waiter2 = new Waiter("Waiter1", order); waiter2.start();
    }
}
