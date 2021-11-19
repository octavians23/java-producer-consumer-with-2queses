package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Order {
    private final Queue<Menu> queue1 = new LinkedList<>();
    private final Queue<Menu> queue2 = new LinkedList<>();
    private static final int MAX_SIZE = 8;
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public void order(Menu menu) throws InterruptedException {
        lock.lock();
        try{
            while(queue1.size()>MAX_SIZE) notFull.await();
            queue1.add(menu);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void cook() throws InterruptedException{
        lock.lock();
        try{
            while(queue1.isEmpty()) notEmpty.await();
            while(queue2.size()>MAX_SIZE) notFull.await();
            Menu menu = queue1.remove();
            queue2.add(menu);
            notFull.signal();
            notEmpty.signal();
        }
        finally {
            lock.unlock();
        }
    }

    public Menu waiter() throws InterruptedException {
        lock.lock();
        try{
            while(queue2.isEmpty()) notEmpty.await();
            notFull.signal();
            return queue2.remove();
        } finally {
            lock.unlock();
        }
    }
}
