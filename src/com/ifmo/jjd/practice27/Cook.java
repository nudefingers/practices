package com.ifmo.jjd.practice27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Cook implements Runnable{
    private ArrayBlockingQueue<Order> garsonToCook;
    private ArrayBlockingQueue<Order> cookToClient;

    public Cook(ArrayBlockingQueue<Order> garsonToCook, ArrayBlockingQueue<Order> cookToClient) {
        this.garsonToCook = Objects.requireNonNull(garsonToCook);
        this.cookToClient = Objects.requireNonNull(cookToClient);
    }
    @Override
    public void run() {
        while (true) {
            try {
                Order orderC = garsonToCook.take();
                orderC.setReady();
                System.out.println(Thread.currentThread().getName() + ": заказ " + orderC.getNumber() + " получен поваром");
                Thread.sleep(3000);
                cookToClient.put(orderC);
                System.out.println(Thread.currentThread().getName() + ": заказ " + orderC.getNumber() + " отдан клиенту");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
