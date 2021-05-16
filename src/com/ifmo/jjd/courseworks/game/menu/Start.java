package com.ifmo.jjd.courseworks.game.menu;

import com.ifmo.jjd.courseworks.game.Section;

import java.util.HashMap;

public class Start implements Command{
    @Override
    public void execute() {
        Section.runGame(Section.createStart());
    }
}
