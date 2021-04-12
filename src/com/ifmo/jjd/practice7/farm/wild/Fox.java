package com.ifmo.jjd.practice7.farm.wild;

import com.ifmo.jjd.practice7.farm.WildAnimal;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Fox extends WildAnimal {
    String name;

    public Fox(String name) {
        super(name);
        weight = Randoms.getRandomInt(3, 15);
        speed = Randoms.getRandomInt(15, 60);
        power = Randoms.getRandomInt(10, 30);
    }
}
