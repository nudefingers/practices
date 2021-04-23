package com.ifmo.jjd.practice16.pupils;

import com.ifmo.jjd.practice13.employee.utils.Randoms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private UUID number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDateTime birth;

    public Pupil(String name, Gender gender, LocalDateTime birth) {
        this.number = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public UUID getNumber() {
        return number;
    }

    public void setNumber(UUID number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public int getBirthYear() {
        return birth.getYear();
    }

    public int getAge() {
        return LocalDateTime.now().getYear() - birth.getYear();
    }


    // TODO: добавить все необходимые методы

    public static Pupil getInstance() {
        String[] names = {"Крис", "Бобби", "Тони", "Сэнди", "Иззи", "Лу", "Никки"};
        LocalDateTime dateBegin = LocalDateTime.of(2014,1, 1, 0, 0, 0);

        return new Pupil(
                names[Randoms.getRandomInt(names.length)],
                Gender.values()[Randoms.getRandomInt(2)],
                dateBegin.minusDays(Randoms.getRandomInt(3600))
        );
    }

    public static List<Pupil> getInstances(int count) {
        ArrayList<Pupil> pupils = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            pupils.add(getInstance());
        }
        return pupils;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth.toLocalDate() +
                '}';
    }
}