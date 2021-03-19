package practice2;

import java.util.Scanner;

public class IfAndSwitch {

    public static void main(String[] args) {

/*      1. Задача на if
        Дана целочисленная переменная count - количество верных ответов.
        В зависимости от значения этой переменной вывести в консоль оценку:
        100 - 90 правильных ответов - отлично
        89 - 60 правильных ответов - хорошо
        59 - 40 правильных ответов - удовлетворительно
        39 - 0 правильных ответов - попробуйте в следующий раз*/

        int count = -2;

        if (count >= 90 && count <= 100) {
            System.out.println("отлично");
        }
        else if (count >= 60 && count < 90) {
            System.out.println("хорошо");
        }
        else if (count >= 40 && count < 60) {
            System.out.println("удовлетворительно");
        }
        else if (count >= 0 && count < 40) {
            System.out.println("попробуйте в следующий раз");
        }
        else {
            System.out.println("неверное значение count");
        }


/*      2. Задача на switch
        Пользователь вводит 3 числа:
        1е - первый операнд
        2e - второй операнд
        3е - оператор
        В зависимости от третьего введенного числа нужно вывести в консоль:
        сумму, разность, умножение, деления чисел, которые ввел пользователь.
        Если 3е введенное число 3, нужно найти сумму,
        если 5 - разность,
        если 7 - результат умножения,
        если 9 - результат деления.*/

        Scanner in = new Scanner(System.in);
        System.out.println("введите первый операнд:");
        double firstNum = in.nextDouble();

        System.out.println("введите второй операнд:");
        double secondNum = in.nextDouble();

        System.out.println("введите оператор:");
        int statement = in.nextInt();

        double result = 0;

        switch (statement) {
            case 3:
                result = firstNum + secondNum;
                System.out.println("результат выполнения: " + result);
                break;
            case 5:
                result = firstNum - secondNum;
                System.out.println("результат выполнения: " + result);
                break;
            case 7:
                result = firstNum * secondNum;
                System.out.println("результат выполнения: " + result);
                break;
            case 9:
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                    System.out.println("результат выполнения: " + result);
                    break;
                }
                else {
                    System.out.println("деление на ноль");
                    break;
                }
            default:
                System.out.println("задано неверное значение операнда");
        }



    } //конец psvm
}
