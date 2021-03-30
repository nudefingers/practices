package com.ifmo.jjd.practice7;

import java.util.Objects;

public class Student extends Human {
    public String subject;
    private int knowledgeLevel;

    public Student(String name, int age, String subject, int knowledgeLevel) {
        Objects.requireNonNull(name, "Имя не может быть null");
        Objects.requireNonNull(subject, "Предмет не может быть null");
        if (knowledgeLevel < 0) {
            throw new IllegalArgumentException("Уровень знаний < 0");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст <= 0");
        }
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.knowledgeLevel = knowledgeLevel;
    }

    public String getSubject() {
        return subject;
    }

    public void toStudy(int knowledgeCount) {
        if (knowledgeCount < 0) {
            System.out.println(knowledgeCount + " не может быть отрицательным");
            return;
        }
        knowledgeLevel += knowledgeCount;
    }
}
