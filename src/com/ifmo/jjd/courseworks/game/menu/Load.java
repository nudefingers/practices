package com.ifmo.jjd.courseworks.game.menu;

import com.ifmo.jjd.courseworks.game.BinHandler;
import com.ifmo.jjd.courseworks.game.Section;

import java.io.File;

public class Load implements Command{
    @Override
    public void execute() {
        BinHandler binHandler = new BinHandler(new File(Menu.class
                .getClassLoader().getResource("section.bin").getPath()));
        Section.runGame(binHandler.readFromFile());
        //Section.runGame(Section.createBrokenSection());
    }
}
