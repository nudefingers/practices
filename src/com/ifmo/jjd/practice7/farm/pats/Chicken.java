package com.ifmo.jjd.practice7.farm.pats;

import com.ifmo.jjd.practice7.farm.Pet;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Chicken extends Pet {
    int resource;

    public Chicken() {
            super(Randoms.getRandomInt(1, 5), Randoms.getRandomInt(10, 20), Randoms.getRandomInt(80, 100), true, true, Randoms.getRandomInt(1, 5));
        }
}
