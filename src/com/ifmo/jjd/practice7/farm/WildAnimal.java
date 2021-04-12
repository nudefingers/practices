package com.ifmo.jjd.practice7.farm;

abstract public class WildAnimal {
    protected int weight;
    protected int speed;
    protected int power;
    protected int kickOut;
    protected String name;

    public WildAnimal(String name) {
        this.kickOut = 0;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    void attack(Pet pet) {
        if (speed <= pet.speed) {
            System.out.println(pet.getClass().getSimpleName() + " убежал от " + toString());
            return;
        }
        if (pet.helth <= power) {
            pet.helth = 0;
            pet.onFarm = false;
            System.out.println(toString() + " съел " + pet.getClass().getSimpleName());
            return;
        }
        if (pet.helth > power) {
            pet.helth -= power;
            System.out.println(toString() + " ранил " + pet.getClass().getSimpleName());
            return;
        }

    }
}
