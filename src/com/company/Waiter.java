package com.company;

public class Waiter extends Thread {
    private final String name;
    private Order order;

    public Waiter(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public void run(){
        while(true){
            try {
                Menu menu = order.waiter();
                System.out.println(menu.toString() + " is now being delivered.");
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
