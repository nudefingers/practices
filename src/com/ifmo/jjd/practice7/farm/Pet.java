package com.ifmo.jjd.practice7.farm;

import com.ifmo.jjd.practice7.farm.pats.ForPats;

import static com.ifmo.jjd.practice7.farm.Settings.*;

abstract public class Pet implements ForPats {
    public int weight;
    public int speed;
    public int helth;
    public int maxHelth = MAX_PET_HELTH;
    public int resourse;
    public boolean eatAble;
    public boolean resoursAble;
    public boolean onFarm;

    public Pet(int weight, int speed, int helth, boolean eatAble, boolean resoursAble, int resourse) {
        this.weight = weight;
        this.speed = speed;
        this.helth = helth;
        this.eatAble = eatAble;
        this.resoursAble = resoursAble;
        this.resourse = resourse;

    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

}
