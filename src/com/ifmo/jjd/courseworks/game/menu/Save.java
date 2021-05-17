package com.ifmo.jjd.courseworks.game.menu;

import java.io.*;

public class Save implements Command{
    @Override
    public void execute() {
        String fileName = "resources/Section.bin";
        try (FileOutputStream output = new FileOutputStream(fileName)) {
            byte[] byteSection = Menu.getInstance().getSectionKey().getBytes("UTF-8");
            output.write(byteSection);
            System.out.println("Игра сохранена.\n");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu.getInstance().runCommand();
    }
}
