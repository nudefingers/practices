package com.ifmo.jjd.courseworks.game.menu;

import com.ifmo.jjd.courseworks.game.Section;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Load implements Command{
    @Override
    public void execute() {
        String fileName = "resources/Section.bin";

        try {
            String key = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)
                    .findFirst()
                    .orElse("");

            Section.runGame(Section.getSectionByKey(key));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
