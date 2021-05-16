package com.ifmo.jjd.courseworks.game.menu;

import com.ifmo.jjd.courseworks.game.Section;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Load implements Command{
    @Override
    public void execute() {
        String fileName = "Section.bin";

        try {
            String key = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)
                    .findFirst()
                    .orElse("");
            System.out.println(key);
            Section.runGame(Section.getSectionByKey(key));
            //Section.runGame(Section.createBrokenSection()); // todo посмотреть загрузку дурацкой секции
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
