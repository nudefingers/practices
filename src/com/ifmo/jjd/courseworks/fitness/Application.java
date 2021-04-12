package com.ifmo.jjd.courseworks.fitness;

import com.ifmo.jjd.courseworks.fitness.utils.Randoms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {

        {   /*Owner guest1 = new Owner("Ирина", "Щеклеина", 1957);
            Owner guest2 = new Owner("Мария", "Заводчикова", 1961);
            Owner guest3 = new Owner("Доментий", "Рахматулин", 1995);
            Owner guest4 = new Owner("Ирина", "Гущина", 1956);
            Owner guest5 = new Owner("Эльвира", "Козуро", 1982);
            Owner guest6 = new Owner("Виктория", "Кириллова", 1975);
            Owner guest7 = new Owner("Мария", "Магаляс", 1989);
            Owner guest8 = new Owner("Владимир", "Усов", 1990);
            Owner guest9 = new Owner("Инга", "Шатковская", 1991);
            Owner guest10 = new Owner("Ольга", "Бобошко", 1991);
            Owner guest11 = new Owner("Павел", "Никитин", 1992);
            Owner guest12 = new Owner("Дина", "Александр", 1991);
            //Owner guest13 = new Owner("Вадим", "Алейник", 1855);
            Owner guest14 = new Owner("Альбина", "Латыпова", 1990);
            Owner guest15 = new Owner("Виктор", "Сотник", 1989);
            Owner guest16 = new Owner("Виктория", "Машевская", 1992);
            Owner guest17 = new Owner("Алексей", "Михалычев", 1966);
            Owner guest18 = new Owner("Валерий", "Мостович", 1951);
            Owner guest19 = new Owner("Наталья", "Павлова", 1993);
            Owner guest20 = new Owner("Дина", "Храброва", 1962);
            Owner guest21 = new Owner("Леонид", "Крупник", 1961);
            //Owner guest22 = new Owner("Ольга", "Бе", 1967);
            Owner guest23 = new Owner("Борис", "Залялов", 1949);
            Owner guest24 = new Owner("Вероника", "Мелнис", 1960);
            Owner guest25 = new Owner("Татьяна", "Баранова", 1993);
            Owner guest26 = new Owner("Дарья", "Овсянникова", 1993);
            Owner guest27 = new Owner("Александр", "Дмитриев", 1992);
            //Owner guest28 = new Owner("Наталия", "Чупрасова", 0);
            Owner guest29 = new Owner("Александра", "Купесова", 1989);
            Owner guest30 = new Owner("Эрик", "Малышев", 1992);
            Owner guest31 = new Owner("Григорий", "Кибис", 1989);
            Owner guest32 = new Owner("Дмитрий", "Иванов", 1990);
            Owner guest33 = new Owner("Максим", "Глухих", 1900);
            Owner guest34 = new Owner("Татьяна", "Абрамкина", 1991);
            Owner guest35 = new Owner("Анастасия", "Громова", 1992);
            //Owner guest36 = new Owner("Вадим", "Бабаев", 0);
            Owner guest37 = new Owner("Николай", "Макаров", 2001);
            Owner guest38 = new Owner("Валерий", "Гордиенко", 1970);
            Owner guest39 = new Owner("Александр", "Масленников", 1927);
            Owner guest40 = new Owner("Ольга", "Лобановская", 1963);
            Owner guest41 = new Owner("Павел", "Загорский", 1996);
            Owner guest42 = new Owner("Глеб", "Андреев", 1994);
            Owner guest43 = new Owner("Дмитрий ", "Парфёнов", 1997);
            Owner guest44 = new Owner("Алексей", "Сметанников", 1996);
            Owner guest45 = new Owner("Екатерина", "Андрианова", 1996);
            Owner guest46 = new Owner("Рустам", "Мавланов", 1994);
            Owner guest47 = new Owner("Валерия", "Лобанова", 1996);
            Owner guest48 = new Owner("Валерия", "Авдеева", 1995);
            Owner guest49 = new Owner("Екатерина", "Чернушевич", 1997);
            Owner guest50 = new Owner("Любовь", "Яценко", 1997);
            Owner guest51 = new Owner("Дарья", "Семенова", 1996);
            Owner guest52 = new Owner("Валерия", "Мельник", 1995);
            Owner guest53 = new Owner("Наталья", "Миловидова", 1997);
            Owner guest54 = new Owner("Лилия", "Прима", 1995);
            Owner guest55 = new Owner("Юлия", "Лагуткина", 1996);
            Owner guest56 = new Owner("Анастасия", "Невструева", 1995);
            Owner guest57 = new Owner("Наталья", "Александрова", 1945);
            Owner guest58 = new Owner("Никита", "Володин", 1996);
            Owner guest59 = new Owner("Екатерина", "Олехнович", 1996);
            Owner guest60 = new Owner("Дарья", "Хрусталева", 1997);
            Owner guest61 = new Owner("Вячеслав", "Дятчин", 1995);
            Owner guest62 = new Owner("Евгения", "Хромова", 1996);
            Owner guest63 = new Owner("Ольга", "Куребекова", 1996);
            Owner guest64 = new Owner("Айна", "Чырахова", 1996);
            Owner guest65 = new Owner("Егор", "Надуда", 1995);
            Owner guest66 = new Owner("Илья", "Сураев", 1996);
            Owner guest67 = new Owner("Евгений", "Гущин", 1996);
            Owner guest68 = new Owner("Елена", "Ермакова ", 1996);
            Owner guest69 = new Owner("Арина", "Паровишник", 1996);
            Owner guest70 = new Owner("Всеволод", "Улитко", 1997);
            Owner guest71 = new Owner("Алена", "Шимко", 1996);
            Owner guest72 = new Owner("Софья", "Кузьмина", 1996);
            Owner guest73 = new Owner("Максим", "Татаринов", 1996);
            //Owner guest74 = new Owner("Анастасия", "Чиркова", 2015);
            Owner guest75 = new Owner("Кристина", "Фокина", 1996);
            Owner guest76 = new Owner("Елизавета", "Ткачук", 1997);
            Owner guest77 = new Owner("Ольга", "Шоломицкая", 1997);
            Owner guest78 = new Owner("Денис", "Новиков", 1996);
            Owner guest79 = new Owner("Артемий", "Таранов", 1997);
            Owner guest80 = new Owner("Артем", "Гвоздик", 1991);
            Owner guest81 = new Owner("Наталья", "Афанасьева", 1996);
            Owner guest82 = new Owner("Денис", "Степанов", 1996);
            Owner guest83 = new Owner("Даниил", "Лучка", 1996);
            Owner guest84 = new Owner("Екатерина ", "Трохачева", 1996);
            Owner guest85 = new Owner("Денис", "Григорьев", 1996);
            Owner guest86 = new Owner("Нарек", "Саакян", 1996);
            Owner guest87 = new Owner("Карина", "Вялова", 1995);
            Owner guest88 = new Owner("Игорь", "Карасев", 1996);
            Owner guest89 = new Owner("Наталия", "Смородина", 2000);
            Owner guest90 = new Owner("Наталья", "Кашколда", 1996);
            Owner guest91 = new Owner("Юрий", "Филиппов", 1900);
            Owner guest92 = new Owner("Артем", "Сидорин", 1996);
            Owner guest93 = new Owner("Алексей", "Гончаров", 1996);
            Owner guest94 = new Owner("Владислав", "Шарамков", 1996);
            Owner guest95 = new Owner("Ярослав", "Рочняк", 1995);
            Owner guest96 = new Owner("Виктор", "Саламатов", 1993);
            Owner guest97 = new Owner("Мария", "Иванова", 1997);
            Owner guest98 = new Owner("Денис", "Зинган", 1993);
            Owner guest99 = new Owner("Виктория", "Крон", 2002);
            Owner guest100 = new Owner("Кирилл", "Иванов", 1997);*/ }

        Fitness fitness = new Fitness();
        Owner[] clients = new Owner[10];

        {
            Owner guest1 = new Owner("Ирина", "Щеклеина", 1957);
            guest1.buyMembership();
            clients[0] = guest1;
            Owner guest2 = new Owner("Мария", "Заводчикова", 1961);
            guest2.buyMembership();
            clients[1] = guest2;
            Owner guest3 = new Owner("Доментий", "Рахматулин", 1995);
            guest3.buyMembership();
            clients[2] = guest3;
            Owner guest4 = new Owner("Ирина", "Гущина", 1956);
            guest4.buyMembership();
            clients[3] = guest4;
            Owner guest5 = new Owner("Эльвира", "Козуро", 1982);
            guest5.buyMembership();
            clients[4] = guest5;
            Owner guest6 = new Owner("Виктория", "Кириллова", 1975);
            guest6.buyMembership();
            clients[5] = guest6;
            Owner guest7 = new Owner("Мария", "Магаляс", 1989);
            guest7.buyMembership();
            clients[6] = guest7;
            Owner guest8 = new Owner("Владимир", "Усов", 1990);
            guest8.buyMembership();
            clients[7] = guest8;
            Owner guest9 = new Owner("Инга", "Шатковская", 1991);
            guest9.buyMembership();
            clients[8] = guest9;
            Owner guest10 = new Owner("Ольга", "Бобошко", 1991);
            guest10.buyMembership();
            clients[9] = guest10;
        }

        for (Owner client : clients) {
            client.comeToClub(fitness , Area.values()[Randoms.getRandomInt(3)]);
        }

        fitness.aboutAreas(LocalDateTime.now());

        clients[1].leaveClub(fitness);
        clients[2].leaveClub(fitness);
        clients[3].leaveClub(fitness);
        clients[4].leaveClub(fitness);

        fitness.aboutAreas(LocalDateTime.now());

        clients[9].comeToClub(fitness, Area.GYM);

        fitness.closes();

        fitness.aboutAreas(LocalDateTime.now());

    }

}
