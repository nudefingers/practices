package com.ifmo.jjd.courseworks.game.menu;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    HashMap<Integer, Command> commands = new HashMap<>();

    public void setCommands() {
        commands.put(1, new Start());
        commands.put(2, new Load());
        commands.put(3, new LogOut());
        commands.put(4, new Save());
    }
    
    public void runCommand(int item) {
        commands.get(item).execute();
    }

    public static int selectMenuItem (boolean itemSave) {
        int itemCount = 3;
        String textMenu = "1. Начать игру\n" +
                "2. Загрузить игру\n" +
                "3. Выйти";
        if (itemSave) {
            textMenu += "\n4. Сохранить игру";
            itemCount ++;
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите пунк меню:");
            System.out.println(textMenu);

            int userInt = scanner.nextInt();
            if (userInt <= itemCount && userInt > 0) {
                return userInt;
            }
            else {
                System.out.println("Неверный пунк меню\n");
                continue;
            }
        }
    }
}
