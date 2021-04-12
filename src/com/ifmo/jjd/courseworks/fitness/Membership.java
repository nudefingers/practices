package com.ifmo.jjd.courseworks.fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Membership {

    Type type;
    LocalDateTime dateBegin;
    LocalDateTime dateEnd;
    Owner owner;

    enum Type {
        ON_OFF(true, true, false, LocalTime.of(8,0), LocalTime.of(22, 0)),
        DAY(false, true, true, LocalTime.of(8,0), LocalTime.of(16, 0)),
        FULL(true, true, true, LocalTime.of(8,0), LocalTime.of(22, 0));

        boolean pool;
        boolean gym;
        boolean group;
        LocalTime timeStart;
        LocalTime timeEnd;

        Type(boolean pool, boolean gym, boolean group, LocalTime timeStart, LocalTime timeEnd) {
            this.pool = pool;
            this.gym = gym;
            this.group = group;
            this.timeStart = timeStart;
            this.timeEnd = timeEnd;
        }
    }

    public Membership(Type type, int daysCount) {

        this.type = type;
        this.dateBegin = LocalDateTime.of(LocalDate.now(), type.timeStart);

        if (type == Type.ON_OFF && daysCount > 1) {
            System.out.println("--Дневной абонемент действителен до 22 часов текущего дня--");
            this.dateEnd = LocalDateTime.of(dateBegin.toLocalDate(), type.timeEnd);
            return;
        }
        this.dateEnd = LocalDateTime.of(dateBegin.plusDays(daysCount).toLocalDate(), type.timeEnd);
    }

    public void setOwner(Owner owner) {
        Objects.requireNonNull(owner, "Owner не может быть null");
        this.owner = owner;
    }

    public String getOwnerName() {
        return owner.name;
    }

    public String getOwnerSurname() {
        return owner.surname;
    }

    public int getOwnerbirthYear() {
        return owner.birthYear;
    }

    @Override
    public String toString() {
        return "(" + type + ")";
    }
}
