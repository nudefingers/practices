package com.ifmo.jjd.practice7.farm;


import com.ifmo.jjd.practice7.farm.pats.Cat;
import com.ifmo.jjd.practice7.farm.pats.Chicken;
import com.ifmo.jjd.practice7.farm.pats.Cow;
import com.ifmo.jjd.practice7.farm.pats.Rabbit;
import com.ifmo.jjd.practice7.farm.utils.Randoms;

import static com.ifmo.jjd.practice7.farm.Settings.*;

public class Farmer {
    public int resource;
    public Farm farm;

    public Farmer() {
        this.resource = FARMER_RESOURSE;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public int getResources() {
        int getRessourses = 0;

        for (Pet pet : farm.pets) {
            if (pet.onFarm && pet.resoursAble) getRessourses += pet.resourse;
            System.out.println("Фермер собрал " + getRessourses + " ресурсов");
        }

        return getRessourses;
    }

    void eat() {
        int eatAbleOnFarm = 0;

        for (Pet pet : farm.pets) {
            if (pet.onFarm && pet.eatAble) eatAbleOnFarm +=1;
        }

        Pet[] pets = new Pet[eatAbleOnFarm];
        for (int i = 0; i < eatAbleOnFarm; i++) {
            for (Pet pet : farm.pets) {
                if (pet.onFarm && pet.eatAble) pets[i] = pet;
            }
        }

        int petIndex = Randoms.getRandomInt(eatAbleOnFarm - 1);
        resource += pets[petIndex].weight;
        pets[petIndex].onFarm = false;
        System.out.println("Фермер съел " + pets[petIndex].getClass().getName() + " весом " + pets[petIndex].weight);
    }

    boolean kickOut(WildAnimal wildAnimal) {
        if (Randoms.getRandomInt(1) == 1) {
            wildAnimal.kickOut +=1;
            System.out.println("Фермер прогнал " + wildAnimal.toString());
            return true;
        }
        System.out.println(wildAnimal.toString() + " увернулся от фермера");
        return false;
    }

    void feed() {
        for (Pet pet : farm.pets) {
            if (pet.onFarm) resource += pet.resourse;
            pet.helth = Math.min(MAX_PET_HELTH, pet.helth +1);
            System.out.println("Фермер собрал " + pet.resourse + " ресурсов");
        }
    }
}
