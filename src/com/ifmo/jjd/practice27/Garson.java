package com.ifmo.jjd.practice27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Garson implements Runnable{
    private ArrayBlockingQueue<Order> clientToGarson;
    private ArrayBlockingQueue<Order> garsonToCook;

    public Garson(ArrayBlockingQueue<Order> clientToGarson, ArrayBlockingQueue<Order> garsonToCook) {
        this.clientToGarson = Objects.requireNonNull(clientToGarson);
        this.garsonToCook = Objects.requireNonNull(garsonToCook);
    }
    @Override
    public void run() {
        while (true) {
            try {
                Order orderG = clientToGarson.take();
                orderG.setTaken();
                System.out.println(Thread.currentThread().getName() + ": заказ " + orderG.getNumber() + " обработан официантом");
                Thread.sleep(3000);
                garsonToCook.put(orderG);
                System.out.println(Thread.currentThread().getName() + ": заказ " + orderG.getNumber() + " передан повару");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
