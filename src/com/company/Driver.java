package com.company;


public class Driver extends Thread{
    private final String name;
    private Order order;
    private static int id;

    public Driver(String name, Order order) {
        this.name = name;
        this.order = order;
    }


        @Override
    public void run(){
        while(true){
            int id1 = id++;
            Menu menu = new Menu();
            try {
                order.order(menu);
                System.out.println("The order " + menu.toString() + " with the id " + id1 + " is now being cooked");
                sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
