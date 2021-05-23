package com.ifmo.jjd.practice27;

import java.util.concurrent.ArrayBlockingQueue;

public class Application {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> clientToGarson = new ArrayBlockingQueue<>(10, true);
        ArrayBlockingQueue<Order> garsonToCook = new ArrayBlockingQueue<>(10, true);
        ArrayBlockingQueue<Order> cookToClient = new ArrayBlockingQueue<>(10, true);

        Thread client = new Thread(
                new Client(clientToGarson, cookToClient)
        );
        Thread garson = new Thread(
                new Garson(clientToGarson, garsonToCook)
        );
        Thread cook = new Thread(
                new Cook(garsonToCook, cookToClient)
        );
        client.start();
        garson.start();
        cook.start();
    }
}
