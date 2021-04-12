package com.ifmo.jjd.practice7.farm.wild;

import com.ifmo.jjd.practice7.farm.WildAnimal;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Wolf extends WildAnimal {
    String name;

    public Wolf(String name) {
        super(name);
        weight = Randoms.getRandomInt(30, 80);
        speed = Randoms.getRandomInt(15, 60);
        power = Randoms.getRandomInt(20, 80);
    }
}
