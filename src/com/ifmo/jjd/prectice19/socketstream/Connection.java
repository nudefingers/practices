package com.ifmo.jjd.prectice19.socketstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable{
    // класс для клиент-серверного взаимодействия
    // данные будут передаваться как последовательность байт
    // по TCP-протоколу
    private Socket socet;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socet) throws IOException {
        this.socet = socet;
        // getOutputStream - это streamAPI, который позволит передать данные
        output = new ObjectOutputStream(socet.getOutputStream());
        input = new ObjectInputStream(socet.getInputStream());
    }

    // важна последовательность!!!
    // иначе произойдёт блокировка канала
    public void sendMessage(SimpleMessage msg) throws IOException {
        msg.setDateTime();
        output.writeObject(msg);
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socet.close(); //Socket закрывается последним
    }
}
