package com.ifmo.jjd.practice7.farm.wild;

import com.ifmo.jjd.practice7.farm.Pet;
import com.ifmo.jjd.practice7.farm.WildAnimal;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Bear extends WildAnimal {
    String name;

    public Bear(String name) {
        super(name);
        weight = Randoms.getRandomInt(100, 400);
        speed = Randoms.getRandomInt(15, 60);
        power = Randoms.getRandomInt(30, 50);
    }
}
