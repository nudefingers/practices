package com.ifmo.jjd.practice7.school;

import java.util.Objects;

public class Teacher extends Human implements ForTeach {
    public String subject;

    public Teacher(String name, int age, String subject) {
        Objects.requireNonNull(name, "Имя не может быть null");
        Objects.requireNonNull(subject, "Предмет не может быть null");
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст <= 0");
        }
        this.name = name;
        this.subject = subject;
        this.age = age;
    }

    public void toTeach(Student student) {
        Objects.requireNonNull(student, "Ученик не можеть быть null");
        if (!subject.equals(student.subject)) {
            System.out.println("У учителя и ученика разные предметы");
            return;
        }
        student.toStudy(5);
        System.out.println(toString() + " обучил " + student.toString() + " дисциплине " + subject);
    }
}
