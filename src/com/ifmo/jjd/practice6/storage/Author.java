package com.ifmo.jjd.practice6.library;

public class Author {
    private String name;
    private String surname;

//    getters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

//    setters
    public void setName(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Значение name < 3");
        }
        this.name = name;
    }
    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() < 3) {
            throw new IllegalArgumentException("Значение surname < 3");
        }
        this.surname = surname;
    }

//    constructor
    public Author(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}

