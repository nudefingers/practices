package com.ifmo.jjd.practice7.farm;

import com.ifmo.jjd.practice7.farm.pats.Cat;
import com.ifmo.jjd.practice7.farm.pats.Chicken;
import com.ifmo.jjd.practice7.farm.pats.Cow;
import com.ifmo.jjd.practice7.farm.pats.Rabbit;
import com.ifmo.jjd.practice7.farm.utils.Randoms;
import com.ifmo.jjd.practice7.farm.wild.Bear;
import com.ifmo.jjd.practice7.farm.wild.Fox;
import com.ifmo.jjd.practice7.farm.wild.Wolf;

import static com.ifmo.jjd.practice7.farm.Settings.*;

public class Farm {
    Farmer farmer;
    Pet[] pets = new Pet[PETS_COUNT];
    WildAnimal[] wilds = new WildAnimal[WILD_COUNT];

    public Farm(Farmer farmer) {
        this.farmer = farmer;
        farmer.setFarm(this);

        for (int i = 0; i < PETS_COUNT; i++) {
            int changePat = Randoms.getRandomInt(1,5);
            switch (changePat) {
                case 1:
                    pets[i] = new Cat();
                    break;
                case 2:
                    pets[i] = new Chicken();
                    break;
                case 3:
                    pets[i] = new Cow();
                    break;
                case 4:
                    pets[i] = new Rabbit();
                    break;
            }
            pets[i].setOnFarm(true);
        }
        wilds[0] = new Bear("медведь");
        wilds[1] = new Bear("лиса");
        wilds[2] = new Bear("волк");
    }

    public void passDay() {

        System.out.println("У фермера " + farmer.resource + " ресурсов");
        System.out.println("**********");

        // 1. Фермер тратит 2 единицы ресурсов (если ресурсов не осталось, игра заканчивается).
        farmer.resource -= 2;
        if (farmer.resource < 0) {
            System.out.println("У фермера недостаточно ресурсов");
            return;
        }
        int randomIndexWild = Randoms.getRandomInt(WILD_COUNT - 1);
        int randomIndexPet = Randoms.getRandomInt(PETS_COUNT - 1);

//      3. Иногда (рандомно) фермер может прогнать дикое животное.
        farmer.kickOut(wilds[randomIndexWild]);

/*      2. Приходит дикое животное (выбирается рандомно из массива с дикими животными),
        пытается поймать (съесть, либо ранить) домашнее животное (выбирается рандомно).
        Если домашнее животное убежало, дикое уходит ни с чем.*/
        wilds[randomIndexWild].attack(pets[randomIndexPet]);

//      4. Фермер кормит всех животных (животные восполняют здоровье)
        farmer.feed();

/*      5. Фермер собирает ресурсы с животных, с которых можно их собирать.
        Если таких не осталось, съедает животное, пригодное в пищу (если такие остались).*/
        int getRessourses = farmer.getResources();
        if (getRessourses > 0) farmer.resource += getRessourses;
        else farmer.eat();

        System.out.println("**********");
        System.out.println("У фермера " + farmer.resource + " ресурсов");
    }

}
