package com.ifmo.jjd.courseworks.fitness;

import com.ifmo.jjd.courseworks.fitness.utils.Randoms;

public enum Area {
    POOl("бассейн"),
    GYM("тренажерный зал"),
    GROUP("групповые занятия");

    String name;

    Area(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
