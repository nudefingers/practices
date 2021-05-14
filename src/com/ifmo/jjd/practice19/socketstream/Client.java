package com.ifmo.jjd.practice19.socketstream;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;


    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите имя");
        String userName = scanner.nextLine();

        String text;
        while (true) {
            System.out.println("Введите сообщение");
            text = scanner.nextLine();

            if ("exit".equals(text)) break;
            // TODO: 04.05.2021 отправляем картинку
            if ("/image".equals(text)) {
                sendAndPrintMessage(SimpleMessage.getMessage(userName, text, getImage()));
            }
            else {
                sendAndPrintMessage(SimpleMessage.getMessage(userName, text));
            }
            if ("/exit".equals(text)) break;
        }
    }

    private void sendAndPrintMessage(SimpleMessage msg) {
        try(Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(msg);
            SimpleMessage fromServer = connection.readMessage();
            if (fromServer.getText().startsWith("/ping ")) {
                LocalDateTime depatureDate = LocalDateTime.parse(fromServer.getText()
                        .replace("/ping ", ""));
                System.out.println("от сервера: " + ChronoUnit.NANOS.between(depatureDate, LocalDateTime.now()) + " nanos");
            }
            else if (fromServer.getText().startsWith("/exit ")) {
                connection.close();
            }
            else {
                System.out.println("от сервера: " + fromServer);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getImage() {
        String pathName = "my.jpg";
        ImgHandler handler = new ImgHandler(new File(pathName));
        byte[] bytes = new byte[0];
        try {
            bytes = handler.readFromFile();

            return bytes;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
