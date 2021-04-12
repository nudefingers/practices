package com.ifmo.jjd.courseworks.fitness;

import com.ifmo.jjd.courseworks.fitness.utils.Randoms;

import java.time.LocalDateTime;
import java.util.Objects;

public class Owner {
    String name;
    String surname;
    int birthYear;
    Membership membership;

    public Owner(String name, String surname, int birthYear) {
        if (birthYear > 2013) {
            throw new IllegalArgumentException("Вы очень молоды");
        }
        if (birthYear < 1900) {
            throw new IllegalArgumentException("Вы не существуете");
        }
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Значение name < 3");
        }
        if (surname == null || surname.trim().length() < 3) {
            throw new IllegalArgumentException("Значение surname < 3");
        }
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public void buyMembership() {
        Membership membership = new Membership(Membership.Type.values()[Randoms.getRandomInt(3)], Randoms.getRandomInt(1, 365));
        membership.setOwner(this);
        this.membership = membership;

        System.out.println(this.toString() + " купил абонемент " + membership.type);
    }

    public void comeToClub(Fitness fitness, Area area) {

        Objects.requireNonNull(this, "Owner не может быть null");
        if (this != membership.owner) System.out.println(toString() + ": Это не Ваш абонемент");

        if (fitness.selectArea(membership, area)) {
            if (fitness.addToArea(membership, fitness.areaConformity(area))) {
                fitness.aboutVisit(membership, area, LocalDateTime.now());
            }
        }

    }

    public void leaveClub(Fitness fitness) {

        Objects.requireNonNull(this, "Owner не может быть null");

        fitness.leaveArea(membership, fitness.swimmers);
        fitness.leaveArea(membership, fitness.bodybuilders);
        fitness.leaveArea(membership, fitness.groupies);

        System.out.println(toString() + ": До свидания! Ждём Вас снова!");

    }


}
