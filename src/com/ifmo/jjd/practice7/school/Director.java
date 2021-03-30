package com.ifmo.jjd.practice7;

import java.util.Objects;

public class Director extends Human {
    public Director(String name, int age) {
        Objects.requireNonNull(name, "Имя не может быть null");
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст <= 0");
        }
        this.name = name;
        this.age = age;
    }

    public void startClasses() {
        System.out.println("--начало занятий--");
    }

    public void finishClasses() {
        System.out.println("--окончание занятий--");
    }
}
