package com.ifmo.jjd.courseworks.game.menu;

import com.ifmo.jjd.courseworks.game.Section;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private static Menu instance;
    private HashMap<Integer, Command> commands = new HashMap<>();
    private Section section;
    private boolean itemSave = false;

    private Menu() {
        setCommands();
        section = Section.createStart();
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getSectionKey() {
        return section.getTitle();
    }

    private void setCommands() {
        commands.put(1, new Start());
        commands.put(2, new Load());
        commands.put(3, new Exit());
        commands.put(4, new Save());
    }
    
    public void runCommand() {
        commands.get(selectMenuItem()).execute();
    }

    private int selectMenuItem() {
        int itemCount = 3;
        String textMenu = """
                    1. Начать игру
                    2. Загрузить игру
                    3. Выйти
                    """;
        if (itemSave) {
            textMenu += "4. Сохранить игру";
            itemCount ++;
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите пункт меню:");
            System.out.println(textMenu);

            int userInt = scanner.nextInt();
            if (userInt <= itemCount && userInt > 0) {
                itemSave = true;
                return userInt;
            }
            else {
                System.out.println("Неверный пунк меню\n");
                continue;
            }
        }
    }

}
