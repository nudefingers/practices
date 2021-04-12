package com.ifmo.jjd.practice6.cats_mice;

import com.ifmo.jjd.practice6.storage.Book;

import java.util.Arrays;
import java.util.Objects;

public class Cat {
    private String name;
    private String color;
    private int speed;
    private int weight;
    private Mouse[] trappedMice;

    public Cat(String name, String color, int speed, int weight) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Значение name < 3");
        }
        this.name = name;

        if (color == null || color.trim().length() < 3) {
            throw new IllegalArgumentException("Значение color < 3");
        }
        this.color = color;

        if (speed < 0) throw new IllegalArgumentException("Скорость не может быть отрицательной");
        this.speed = speed;

        if (weight <= 0) throw new IllegalArgumentException("Вес должен быть положительным");
        this.weight = weight;

        int miceCount = 100;
        this.trappedMice = new Mouse[miceCount];
    }

    public void hunting(Mouse mouse) {
        Objects.requireNonNull(this, "Кот не может быть null");
        Objects.requireNonNull(mouse, "мышь не может быть null");
        if (speed <= mouse.speed) {
            System.out.println("Мышка (скорость = " + mouse.speed + ") убежала от кота " + name);
            return;
        }
        else {
            for (int i = 0; i < trappedMice.length; i++) {
                if (trappedMice[i] == null) {
                    trappedMice[i] = mouse;
                    System.out.println("Кот " + name + " поймал мышку (скорость = " + mouse.speed + ")");
                    return;
                }
            }
        }
    }

    public void fight(Cat anotheCat) {
        Objects.requireNonNull(this, "Кот не может быть null");
        Objects.requireNonNull(anotheCat, "Кот не может быть null");

        if (weight == anotheCat.weight) {
            System.out.println("Коты в одной весовой категории");
        }
        else {
            Cat winner = (weight > anotheCat.weight) ? this : anotheCat;
            Cat loser  = (weight < anotheCat.weight) ? this : anotheCat;

            System.out.println("Кот " + winner.name + " одолел кота " + loser.name);

            for (int l = 0; l < loser.trappedMice.length; l++) {
                for (int w = 0; w < winner.trappedMice.length; w++) {
                    if (loser.trappedMice[l] != null) {
                        winner.hunting(loser.trappedMice[l]);
                        break;
                    }
                }
                loser.trappedMice[l] = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder miceInLine = new StringBuilder();
        for (Mouse mouse : trappedMice) {
            if (mouse != null) {
                miceInLine.append(mouse.toString()).append("\n");
            }
        }

        return "Кот " + name + " {" +
                "цвет " + color + ", " +
                "скорость " + speed + ", " +
                "вес " + weight +
                '}' + '\n' +
                "пойманные мышки:" + '\n' +
                miceInLine;
    }
}
