package com.ifmo.jjd.practice6.library;

public class Application {
    public static void main(String[] args) {
        Book chidren8 = new Book("Папа, мама, бабушка, восемь детей и грузовик", 1,200,2000);
        Author vestli = new Author("Анне-Катрине", "Вестли");
        chidren8.addAuthor(vestli);
        //System.out.println(chidren8.toString());

        Author gebel = new Author("Доро", "Гёбель");
        Author knorr = new Author("Петер", "Кнорр");
        Book vimmelbuh = new Book("За городом", 2,14, 2017);
        //vimmelbuh.addAuthor(null);
        vimmelbuh.addAuthor(gebel);
        vimmelbuh.addAuthor(knorr);
        vimmelbuh.addAuthor(gebel);
        //System.out.println(vimmelbuh.toString());

        Book vimmelbuhCopy = vimmelbuh;
        System.out.println("*************");

        Storage lermontovka = new Storage(22);
        lermontovka.addBooks(vimmelbuh, chidren8);
        System.out.println(lermontovka.toString());



    } // end psvm
}
