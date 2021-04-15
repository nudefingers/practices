package com.ifmo.jjd.practice13.employee.utils;

public class Randoms {
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
}
