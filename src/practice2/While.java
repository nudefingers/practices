package practice2;

import java.util.Scanner;

public class While {

    public static void main(String[] args) {

/*      3. Задача на цикл while
        Считать с консоли количество тарелок и количество моющего средства
        Моющее средство расходуется из расчета 0.5 на 1 тарелку
        В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
        В конце вывести сколько тарелок осталось, когда моющее средство закончилось или наоборот.*/

        Scanner in = new Scanner(System.in);
        System.out.println("введите количество тарелок:");
        int plates = in.nextInt();

        System.out.println("введите количество моющего средства:");
        double fairy = in.nextDouble();

        while (plates > 0 && fairy > 0) {

            --plates;
            fairy -= 0.5;

            if (fairy != 0) {
                System.out.println("осталось " + fairy + " моющего средства");
            }
        }

        System.out.println("*********************************");
        if (plates == 0) {
            System.out.println("осталось моющего средства: " + fairy);
        }
        if (fairy == 0) {
            System.out.println("осталось немытых тарелок: " + plates);
        }

    }//psvm
}
