/*      Задача "Школа":

        Класс Ученик
        создается со следующими характеристиками:
        имя (тип String)
        возраст (тип int)
        изучаемый предмет (тип String)
        уровень знаний (тип int)
        и методом:
        учиться() - уровень знаний ученика повышается

        Класс Учитель
        создается со следующими харатеристиками:
        имя (тип String)
        возраст (тип int)
        преподаваемый предмет (тип String)
        и методом:
        учить(обучаемый) - тип данных обучаемого определить самостоятельно

        Класс Директор
        создается со следующими харатеристиками:
        имя (тип String)
        возраст (тип int)
        и методами:
        объявить начало занятий()
        объявить окончание занятий занятий()

        Класс Школа
        создается со следующими харатеристиками:
        название - задается при создании объекта и не может быть изменено в последствии
        директор - школа не может функционировать без директора
        учителя[] - массив
        ученики[] - массив
        и методом:
        день в школе() -
        1. директор объявляет начало занятий
        2. учителя учат учеников (предмет учителя и ученика должны совпадать)
        3. директор объявляет окончание занятий

        Методы учить() и учиться() необходимо описать в разных интерфейсах
        Общие свойства необходимо вынести в родительские классы (какие определить самостоятельно)
        В классах можно добавлять методы и свойства при необходимости*/

package com.ifmo.jjd.practice7.school;

public class Application {
    public static void main(String[] args) {
        Director dir = new Director("Albus Dumbledore", 100);
        Teacher minerva = new Teacher("Minerva Mcgonagall", 59, "Transfiguration");
        Teacher hagrid = new Teacher("Rubeus Hagrid", 37, "Care of Magical Creatures");

        Student harry = new Student("Harry Potter", 7, "Care of Magical Creatures", 50);
        Student ron = new Student("Ron Weasley", 8,"Care of Magical Creatures", 2);
        Student hermione = new Student("Hermione Granger", 6, "Transfiguration", 88);

        School hogvards = new School("Hogvards", dir, 7, 200);

        hogvards.addTichers(minerva, hagrid);
        hogvards.addStudents(ron, hermione);
        hogvards.addHuman(harry);

        hogvards.dayAtSchool();
    }
}
