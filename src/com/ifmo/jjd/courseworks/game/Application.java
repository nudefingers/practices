package com.ifmo.jjd.courseworks.game;

import com.ifmo.jjd.courseworks.game.menu.Menu;

public class Application {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setCommands();
        int menuItem = Menu.selectMenuItem(false);
        menu.runCommand(menuItem);
    }
}
