package com.ifmo.jjd.practice19.socketstream;

public class ClientApplication {
    public static void main(String[] args) {
        new Client("127.0.0.1", 8994).start();

        // если нужно запустить несколько клиентов:
        // Edit configurations -> Modify options -> Allow pultiple instance

    }
}
