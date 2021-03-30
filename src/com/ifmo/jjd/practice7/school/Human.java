package com.ifmo.jjd.practice7;

abstract public class Human {
    protected String name;
    protected int age;

    @Override
    public String toString() {
        return "Human {" +
                "name='" + name + '\'' +
                '}';
    }
}
