package com.ifmo.jjd.courseworks.game.menu;

import java.io.*;

public class Save implements Command{
    @Override
    public void execute() {

        // todo почему не получается сохранить файл в ресурсах???
        //String fileName = Menu.class.getClassLoader().getResource("Section.bin").getPath();
        String fileName = "Section.bin";
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
