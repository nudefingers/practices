package practice2;

public class MathRandomAndIf {

    public static void main(String[] args) {
/*      5. Задача на Math.random() и if
        Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500]
        в интервал (25;200) и выводить результат в консоль.
                Примеры работы программы:
        Число 345 не содержится в интервале (25;200)
        Число 110 содержится в интервале (25;200)*/

        double random = Math.random();

        int bigRandom = (int) (random * (500 - 10) + 10);

        if (bigRandom > 25 && bigRandom < 200) {
            System.out.println("Число " + bigRandom + " содержится в интервале (25;200)");
        }
        else {
            System.out.println("Число " + bigRandom + " не содержится в интервале (25;200)");
        }

    }// end psvm
}
