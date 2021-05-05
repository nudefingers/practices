package com.ifmo.jjd.prectice19.socketstream;

import javax.crypto.spec.PSource;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {
    private int port;
    private Connection connection;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        // момент запуска сервера и ожидания подключений
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            HashSet<String> clients = new HashSet<>();
            while (true) {
                // момент установки соединений
                Socket newClient = serverSocket.accept();
                connection = new Connection(newClient);
                SimpleMessage msg = connection.readMessage();
                clients.add(msg.getSender());
                System.out.println(msg);

/*              /help - список доступных команд
                /count - количество подключений сервера
                /ping - время за которое сообщение доходит до сервера и возвращается обратно
                /exit - пользователь хочет выйти из программы*/

                String text = "отклик сервера";
                switch (msg.getText()) {
                    case "/help":
                        text = "\n/help - список доступных команд\n" +
                                "/count - количество подключений сервера\n" +
                                "/ping - время за которое сообщение доходит до сервера и возвращается обратно\n" +
                                "/exit - пользователь хочет выйти из программы";
                        connection.sendMessage(SimpleMessage.getMessage("server", text));
                        break;
                    case "/count":
                        text = "количество подключений сервера = " + clients.size();
                        connection.sendMessage(SimpleMessage.getMessage("server", text));
                        break;
                    case "/ping":
                        text = "/ping " + msg.getDateTime();
                        connection.sendMessage(SimpleMessage.getMessage("server", text));
                        break;
                    case "/exit":
                        clients.remove(msg.getSender());
                        text = "connection closes";
                        connection.sendMessage(SimpleMessage.getMessage("server", text));
                        connection.close();
                        break;
                    case "/image":
                        text = "picture received";
                        ImgHandler handler = new ImgHandler();
                        handler.setFile(new File("newimg.jpg"));
                        handler.writeToFile(msg.getImage());
                        connection.sendMessage(SimpleMessage.getMessage("server", text));
                        break;
                    default:
                        connection.sendMessage(SimpleMessage.getMessage("server", text));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
