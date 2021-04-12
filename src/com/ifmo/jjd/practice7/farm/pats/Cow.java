package com.ifmo.jjd.practice7.farm.pats;

import com.ifmo.jjd.practice7.farm.Pet;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Cow extends Pet {
    int resource;

    public Cow() {
        super(Randoms.getRandomInt(200, 600), Randoms.getRandomInt(10, 50), Randoms.getRandomInt(30, 90), true, true, Randoms.getRandomInt(1, 5));
    }

}
