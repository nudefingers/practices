package com.ifmo.jjd.practice7.farm.pats;

import com.ifmo.jjd.practice7.farm.Pet;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Rabbit extends Pet {
    int resource;

    public Rabbit() {
        super(Randoms.getRandomInt(1, 8), Randoms.getRandomInt(15, 40), Randoms.getRandomInt(25, 60), true, false, 0);
    }
}