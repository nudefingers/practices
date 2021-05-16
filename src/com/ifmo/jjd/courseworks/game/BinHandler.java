package com.ifmo.jjd.courseworks.game;

import java.io.*;

public class BinHandler {
    private File file;

    public BinHandler(File file) {
        this.file = file;
    }

    public <T> boolean writeToFile(T object) {
        boolean result = false;

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(object);
            result = true;

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }

        return result;
    }

    public <T> T readFromFile() {
        Object o = null;
        try(FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            o = objectInputStream.readObject(); // всегда возвращает Object


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) o;
    }
}
