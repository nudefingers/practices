package com.ifmo.jjd.practice7.school;

abstract public class Human {
    protected String name;
    protected int age;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                '}';
    }
}
