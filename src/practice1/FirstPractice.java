package practice1;

public class FirstPractice {

    public static void main(String[] args) {

        /*2. Задача на тернарный оператор
        Даны переменные типа long start и end.
        Если start меньше end переменной between присвоить значение end - start, в противном случае -1*/
        long start = 1_000_000L, end = 7_000_000L;
        long between = (start < end) ? (between = end - start) : (between = -1);

        System.out.println(between);


        /*3. Задача на арифметические операторы
        Найти сумму цифр 2х значного числа*/
        int number2 = 15;
        number2 = number2 / 10 + number2 % 10;

        System.out.println(number2);


        /*4. Задача на арифметические операторы
        Найти сумму цифр 3х значного числа*/
        int number3 = 888;

        int summ = number3 % 10;
        number3 = number3 / 10;

        summ += number3 / 10 + number3 % 10;

        System.out.println(summ);


    }
}
