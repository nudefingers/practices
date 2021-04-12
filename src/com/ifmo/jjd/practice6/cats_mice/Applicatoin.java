/*      2. Реализовать объектную модель:
        Кот: имя, цвет, скорость, вес, пойманные мыши;
        Мышь: скорость.
        Кот хранит информацию о пойманных мышах (максимум 100).
        Кот ловит мышь, только, если его скорость выше, чем у мыши.
        Кот может напасть на другого кота и, если он больше противника (по весу),
        то может отобрать его мышей (если скорость мыши выше, чем скорость кота, она убежит),
        массив с мышами противника нужно обнулить (всем элементам присвоить значение null).
*/


package com.ifmo.jjd.practice6.cats_mice;

public class Applicatoin {
    public static void main(String[] args) {

        Mouse mouse1 = new Mouse(1);
        Mouse mouse2 = new Mouse(3);
        Mouse mouse3 = new Mouse(5);
        Mouse mouse4 = new Mouse(7);
        Mouse mouse5 = new Mouse(200);

        Cat yasnik = new Cat("Ясник", "розовый", 100, 6);
        Cat marsell = new Cat("Марсель", "жёлтый", 2, 100);

        yasnik.hunting(mouse1);
        yasnik.hunting(mouse2);
        yasnik.hunting(mouse3);
        yasnik.hunting(mouse4);
        yasnik.hunting(mouse5);

        marsell.hunting(mouse1);
        marsell.hunting(mouse2);
        marsell.hunting(mouse3);
        marsell.hunting(mouse4);
        marsell.hunting(mouse5);

        System.out.println("*********");
        System.out.println(yasnik);
        System.out.println(marsell);
        System.out.println("*********");
        yasnik.fight(marsell);
        System.out.println("*********");
        System.out.println(yasnik);
        System.out.println(marsell);


    } // end psvm
}
