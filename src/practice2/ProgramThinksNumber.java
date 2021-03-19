package practice2;

import java.util.Scanner;

public class ProgramThinksNumber {

    public static void main(String[] args) {

/*      4. Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        если введен 0, выводит "выход из программы" (программа завершает работу)*/
        int number = 5, guess = 0;
        System.out.println("Введите свое предположение:");

        if (number < 1 && number > 9) {
            System.out.println("Программа, придумай другое число");
        }
        else {
            while (number != guess) {
                Scanner in = new Scanner(System.in);
                guess = in.nextInt();

                if (guess ==0) {
                    break;
                }
                if (number > guess) {
                    System.out.println("загаданное число больше");
                }
                else if (number < guess) {
                    System.out.println("загаданное число меньше");
                }
                else if (number == guess) {
                    System.out.println("Вы угадали");
                }
            }


        }

    }//end psvm
}
