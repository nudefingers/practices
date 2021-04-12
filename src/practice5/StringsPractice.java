package practice5;

import java.util.Arrays;
import java.util.Scanner;

public class StringsPractice {

    public static void main(String[] args) {

/*      1. Задать массив на n слов.
        В цикле считывать с консоли слова (scanner.nextLine()),
        и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        В итоге в массиве будут только уникальные слова.
        Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
        Перед завершением программы, вывести получившийся массив в консоль*/
        int n = 4;
        boolean add;
        String word;
        Scanner in = new Scanner(System.in);
        String[] wordArr = new String[n];

        for (int i = 0; i < n; i++) {
            add = true;
            System.out.println("Введите слово:");
            word = in.nextLine();

            if (word.equalsIgnoreCase("exit")) break;

            for (int j = 0; j <= i; j++) {
                if (word.equalsIgnoreCase(wordArr[j])) {
                    add = false;
                    break;
                }
            }
            //if (!Arrays.asList(wordArr).contains(word)) wordArr[i] = word; - можно ли использовать?
            if (add) wordArr[i] = word;
            else i--;
        }
        System.out.println(Arrays.toString(wordArr));
        System.out.println("**************************************");


/*        2. Найти количество вхождений одной строки в другую.
          Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза*/
        String bigString = "дом домик домой одомашненный домище дом";
        String smallString = "дом";
        String bigStringRed = " " + bigString + " ";
        String[] bigStringArr = bigStringRed.split(smallString);
        System.out.println("строка " + "\"" + smallString + "\"" + " встречается в строке " + "\"" + bigString + "\"" + " " + (bigStringArr.length - 1) + " раз");
        System.out.println("**************************************");


/*        3. Написать функцию, которая проверяет, является ли строка палиндромом.
          Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
          Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром*/
        System.out.println("Введите строку:");
        String palin = in.nextLine();
        StringBuilder nilap = new StringBuilder(palin.replaceAll(" ", ""));

        if (nilap.reverse().toString().equalsIgnoreCase(palin.replaceAll(" ", ""))) System.out.println("Строка \"" + palin + "\" является палиндромом");
        else System.out.println("Строка \"" + palin + "\" не является палиндромом");
        System.out.println("**************************************");


/*        4. Заменить все буквы в слове на строчные, а первую букву на заглавную*/
        System.out.println("Введите строку: ");
        String line = in.nextLine();
        System.out.println(line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase());
        System.out.println("**************************************");


/*        5. Вводится с клавиатуры массив слов. Определить, сколько слов начинается на определенную букву.*/
        int k = 0;
        System.out.println("Введите массив слов, разделенных пробелом:");
        String stringArr = in.nextLine();
        System.out.println("Введите букву:");
        String litera = in.nextLine();
        if (litera.length() != 1) {
            System.out.println("Вы ввели не одну букву");
        }
        else {
            String[] arrString = stringArr.split(" ");
            for (String s : arrString) {
                if (s.substring(0, 1).equalsIgnoreCase(litera)) k++;
            }
        }
        System.out.println("На букву \"" + litera + "\" начинается " + k + " слов");
        System.out.println("**************************************");

    } // end psvm
}
