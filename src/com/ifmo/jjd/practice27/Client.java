package com.ifmo.jjd.practice27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Client implements Runnable{
    private ArrayBlockingQueue<Order> clientToGarson;
    private ArrayBlockingQueue<Order> cookToClient;

    public Client(ArrayBlockingQueue<Order> clientToGarson, ArrayBlockingQueue<Order> cookToClient) {
        this.clientToGarson = Objects.requireNonNull(clientToGarson);
        this.cookToClient = Objects.requireNonNull(cookToClient);
    }

    @Override
    public void run() {
        while (true) {
            Order orderP = new Order();
            try {
                Thread.sleep(3000);
                clientToGarson.put(orderP);
                System.out.println(Thread.currentThread().getName() + ": заказ " + orderP.getNumber() + " передан официанту");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
                Order orderT = cookToClient.take();
                orderT.setClosed();
                System.out.println(Thread.currentThread().getName() + ": заказ " + orderT.getNumber() + " закрыт");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
