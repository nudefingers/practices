package com.ifmo.jjd.courseworks.game.menu;

import com.ifmo.jjd.courseworks.game.BinHandler;
import com.ifmo.jjd.courseworks.game.Section;
import com.ifmo.jjd.practice23.annotations.AnnotationsLesson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Save implements Command{
    @Override
    public void execute() {
        BinHandler binHandler = new BinHandler(new File(Menu.class
                .getClassLoader().getResource("section.bin").getPath()));
        binHandler.writeToFile(Menu.getInstance().getSection());

        Section section = binHandler.readFromFile();

        //Menu.getInstance().runCommand();
    }
}
