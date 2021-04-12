package com.ifmo.jjd.practice7.farm.pats;

import com.ifmo.jjd.practice7.farm.Pet;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

public class Cat extends Pet {

    public Cat() {
        super(Randoms.getRandomInt(1, 8), Randoms.getRandomInt(30, 60), Randoms.getRandomInt(70, 100), false, false, 0);
    }

}
