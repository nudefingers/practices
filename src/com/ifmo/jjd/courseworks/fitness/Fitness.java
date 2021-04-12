package com.ifmo.jjd.courseworks.fitness;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

import static com.ifmo.jjd.courseworks.fitness.Settings.*;

public class Fitness {

    Membership[] swimmers = new Membership[POOL_COUNT];
    Membership[] bodybuilders = new Membership[GYM_COUNT];
    Membership[] groupies = new Membership[GROUP_COUNT];

    public Fitness() { }

    public void closes() {

        System.out.println("Фитнес-клуб закрывается");

        leaveArea(swimmers);
        leaveArea(bodybuilders);
        leaveArea(groupies);

    }

    public void aboutAreas(LocalDateTime dateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        String dateTimeToStr = formatter.format(dateTime);
        System.out.println(dateTimeToStr + "\n");

        System.out.println(Area.GYM.getName() + ": " + Arrays.toString(aboutArea(Area.GYM)));
        System.out.println(Area.POOl.getName() + ": " + Arrays.toString(aboutArea(Area.POOl)));
        System.out.println(Area.GROUP .getName() + ": " + Arrays.toString(aboutArea(Area.GROUP)));

        System.out.println("&&&&&&&&&&&&");

    }

    public void aboutVisit(Membership membership, Area area, LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        String dateTimeToStr = formatter.format(dateTime);

        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия: ").append(membership.getOwnerSurname()).append("\n");
        sb.append("Имя: ").append(membership.getOwnerName()).append("\n");
        sb.append("Посещаемая зона: ").append(area.getName()).append("\n");
        sb.append("Дата и время посещения: ").append(dateTimeToStr);
        System.out.println("************");

        System.out.println(sb);
    }

    public boolean selectArea(Membership membership, Area area) {

        if (LocalDateTime.now().isBefore(membership.dateBegin) || LocalDateTime.now().isAfter(membership.dateEnd)) {
            System.out.println(membership.owner.toString() + ": По своему абонементу Вы не можете посетить наш клуб сегодня");
            return false;
        }

        if (!isNotRegisted(membership)) return false;

        if (area.equals(Area.POOl)) {
            if (!membership.type.pool) {
                System.out.println(membership.owner.toString() + ": По своему абонементу Вы не можете посещать " + area.getName());
                return false;
            }
            if (areaIsFull(swimmers)) {
                System.out.println(membership.owner.toString() + ": К сожалению, в данный момент " + area.getName() + " полон");
                return false;
            }
        }
        if (area.equals(Area.GYM)) {
            if (!membership.type.gym) {
                System.out.println(membership.owner.toString() + ": По своему абонементу Вы не можете посещать " + area.getName());
                return false;
            }
            if (areaIsFull(bodybuilders)) {
                System.out.println(membership.owner.toString() + ": К сожалению, в данный момент " + area.getName() + " полон");
                return false;
            }
        }
        if (area.equals(Area.GROUP)) {
            if (!membership.type.group) {
                System.out.println(membership.owner.toString() + ": По своему абонементу Вы не можете посещать " + area.getName());
                return false;
            }
            if (areaIsFull(groupies)) {
                System.out.println(membership.owner.toString() + ": К сожалению, в данный момент " + area.getName() + " полон");
                return false;
            }
        }

        return true;
    }

    public boolean areaIsFull(Membership[] area) {
        for (int i = 0; i < area.length; i++) {
            if (area[i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean addToArea(Membership membership, Membership[] area) {
        for (int i = 0; i < area.length; i++) {
            if (area[i] == null) {
                area[i] = membership;
                return true;
            }
        }
        return false;
    }

    public boolean isNotRegisted(Membership membership) {
        for (Membership swimmer : swimmers) {
            if (membership.equals(swimmer)) {
                System.out.println(membership.owner.toString() + ": Ваш абонемент уже зарегистрирован в бассейне");
                return false;
            }
        }
        for (Membership bodybuilder : bodybuilders) {
            if (membership.equals(bodybuilder)) {
                System.out.println(membership.owner.toString() + ": Ваш абонемент уже зарегистрирован в тренажерном зале");
                return false;
            }
        }
        for (Membership groupie : groupies) {
            if (membership.equals(groupie)) {
                System.out.println(membership.owner.toString() + ": Ваш абонемент уже зарегистрирован в зале групповых занятий");
                return false;
            }
        }
        return true;
    }

    public void leaveArea(Membership membership, Membership[] memberships) {
        for (int i = 0; i < memberships.length; i++) {
            if (membership.equals(memberships[i])) memberships[i] = null;
        }
    }

    public void leaveArea(Membership[] memberships) {
        for (int i = 0; i < memberships.length; i++) memberships[i] = null;
    }

    public Membership[] areaConformity(Area area) {
        if (area.getName().equals("бассейн")) return swimmers;
        if (area.getName().equals("тренажерный зал")) return bodybuilders;
        if (area.getName().equals("групповые занятия")) return groupies;

        return null;
    }

    public String[] aboutArea(Area area) {

        Membership[] memberships = areaConformity(area);

        String[] names = new String[memberships.length];

        for (int i = 0; i < memberships.length; i++) {
            if (memberships[i] != null) {
                names[i] = memberships[i].owner.toString();
            }
            else names[i] = "место вакантно";
        }

        return names;
    }

}
