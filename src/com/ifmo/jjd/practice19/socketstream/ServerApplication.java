package com.ifmo.jjd.practice19.socketstream;

public class ServerApplication {
    public static void main(String[] args) {
        new Server(8994).start();
    }
}
