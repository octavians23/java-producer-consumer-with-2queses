package com.company;

public class Cook extends Thread{
    private final String name;
    private Order order;

    public Cook(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public void run(){
        while(true){
            try {
               order.cook();
               sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
