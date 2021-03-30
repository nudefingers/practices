package com.ifmo.jjd.practice7;

import java.util.Arrays;
import java.util.Objects;

public class School {
    public final String name;
    public Director director;
    public Teacher[] teachers;
    public Student[] students;

    public School(String name, Director director, int teachersCount, int studentsCount) {
        Objects.requireNonNull(name, "Название школы не может быть Null");
        Objects.requireNonNull(director, "Директор школы не может быть Null");
        if (teachersCount < 0 || studentsCount < 0) {
            throw new IllegalArgumentException("Количество человек не может быть < 0");
        }

        this.name = name;
        this.director = director;
        this.teachers = new Teacher[teachersCount];
        this.students = new Student[studentsCount];
    }

    public void addTichers(Teacher... teachers) {
        boolean add = false;
        for (Teacher teacher : teachers) {
            Objects.requireNonNull(teacher, "Учитель не может быть null");
            add = false;
            if (!Arrays.asList(this.students).contains(teacher)) {
                for (int i = 0; i < this.students.length; i++) {
                    if (this.teachers[i] == null) {
                        this.teachers[i] = teacher;
                        add = true;
                        break;
                    }
                }
                if (!add) System.out.println("Вакансий учителей нет");
            }
            else System.out.println(teacher.toString() + " уже работает в данной школе");
        }
    }

    public void addStudents(Student... students) {
        boolean add = false;
        for (Student student : students) {
            Objects.requireNonNull(student, "Ученик не может быть null");
            add = false;
            if (!Arrays.asList(this.students).contains(student)) {
                for (int i = 0; i < this.students.length; i++) {
                    if (this.students[i] == null) {
                        this.students[i] = student;
                        add = true;
                        break;
                    }
                }
                if (!add) System.out.println("Вакансий учеников нет");
            }
            else System.out.println(student.toString() + " уже учится в данной школе");
        }
    }

    public void addHuman(Human human) {
        boolean add = false;
        Objects.requireNonNull(human, "Человек не может быть null");

        if (human instanceof Student) addStudents((Student) human);
        if (human instanceof Teacher) addTichers((Teacher) human);

    }

    public void dayAtSchool() {}

}
