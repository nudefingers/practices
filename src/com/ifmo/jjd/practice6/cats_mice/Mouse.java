package com.ifmo.jjd.practice6.cats_mice;

public class Mouse {
    public int speed;

    public int getSpeed() {
        return speed;
    }

    public Mouse(int speed) {
        if (speed < 0) throw new IllegalArgumentException("Скорость не может быть отрицательной");
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Мышь {" +
                "скорость = " + speed +
                '}';
    }
}
