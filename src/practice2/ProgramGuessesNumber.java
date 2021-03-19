package practice2;

import java.util.Scanner;

public class ProgramGuessesNumber {
    public static void main(String[] args) {

/*      6. Пользователь!!! загадывает число в диапазоне от [1 до 100]
        Программа пытается его угадать (используйте метод !!!бинарного поиска - деление отрезка на 2).
        Программа может задавать пользователю вопросы:
        Число равно ...? / Число больше ...? / Число меньше ...? и в зависимости от ответа пользователя принимать решения.
        !!! Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА*/
        int reply = 0, equality = 0;
        int start = 1, finish = 100;
        Scanner in = new Scanner(System.in);
        int guess = (start + finish) / 2;

        while (equality != 1) {
            System.out.println("число равно " + guess + "?");
            equality = in.nextInt();
            if (equality == 1) {
                System.out.println("БИНГО!");
                break;
            }
            else {
                System.out.println("число больше " + guess + "?");
                reply = in.nextInt();
                if (reply == 1) {
                    start = guess;
                }
                else if (reply == 0) {
                    finish = guess;
                }
                else {
                    System.out.println("неверное значение ответа");
                    break;
                }
            }

            guess = (start + finish) / 2;
        }





    }//end psvm
}
