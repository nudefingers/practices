package practice4;

import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {

//        1. Создать одномерный массив типа int на 20 элементов. Заполнить его рандомными значениями от 3 до 500. Поменять местами минимальный и максимальный элементы.
        int[] arr = new int[20];
        int max = 3, min = 500, maxIndex = 0, minIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int) (Math.random() * (500 - 3) + 3);

            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        //System.out.println(Arrays.toString(arr));
        arr[maxIndex] = min;
        arr[minIndex] = max;
        //System.out.println(Arrays.toString(arr));

/*        2. Дан массив целых чисел [78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90].
          Образуйте из него два отсортированных по возрастанию массива, содержащих четные и нечетные числа.*/
        int[] arr2 = {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
        int even = 0;

        for (int elem : arr2) {
            if (elem % 2 == 0) even++;
        }

        Arrays.sort(arr2);
        int[] arrEven = new int[even];
        int[] arrOdd = new int[arr2.length - even];

        int iEven = 0, iOdd =0;
        for (int elem : arr2) {
            if (elem % 2 == 0) {
                arrEven[iEven] = elem;
                iEven++;
            }
            else  {
                arrOdd[iOdd] = elem;
                iOdd++;
            }
        }
        //System.out.println(Arrays.toString(arrEven));
        //System.out.println(Arrays.toString(arrOdd));


/*        3. Дан массив целых чисел [-321, 894, -45, 782, -29, 12, -88]. Отрицательные элементы массива перенести в новый массив.
          Размер массива должен быть равен количеству отрицательных элементов.*/

        int[] arr3 = {-321, 894, -45, 782, -29, 12, -88};
        int negative = 0, j = 0;

        for (int elem : arr3) {
            if (elem < 0) negative++;
        }

        int[] arrNegative = new int[negative];

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 0) {
                arrNegative[j] = arr3[i];
                j++;
            }
        }
        //System.out.println(Arrays.toString(arr3));
        //System.out.println(Arrays.toString(arrNegative));


//        4. Создать массив из чётных чисел [2, 4, 6, 8, 10, 12 ... 18, 20] и вывести элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
        int length = 20 / 2;
        /*for (int i = 2; i <= 20 ; i++) {
            if (i % 2 == 0) length++;
        }*/
        int[] arr4 = new int[length];

        int n = 2;
        for (int i = 0; i < length ; i++) {
            arr4[i] = n;
            n += 2;
        }
        //System.out.println(Arrays.toString(arr4));

        for (int i = 9; i >= 0 ; i--) {
            //System.out.println(arr4[i]);
        }

/*        5. Создать массив из 11 случайных целых чисел из отрезка [-1;1], вывести массив в консоль.
        Определить какой элемент встречается в массиве чаще всего и вывести информацию об этом в консоль.*/
        int[] arr5 = new int[11];
        int[] counter = new int[3];
        for (int i = 0; i < 11 ; i++) {
            arr5[i] = (int) (Math.random() * (2 + 2) - 2);
            counter[arr5[i] + 1] += 1;
        }
        System.out.println(Arrays.toString(arr5));

        int maxCount = 0, maxElem = -1, maxCount2 = 0, maxElem2 = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == maxCount) {
                maxCount2 = counter[i];
                maxElem2 = i;
            }
            else if (counter[i] > maxCount) {
                maxCount = counter[i];
                maxElem = i;
            }
        }
        if (maxCount == maxCount2) System.out.println("В массиве чаще всего встречаются элементы " + (maxElem - 1)  + " и " + (maxElem2 - 1) + " (" + maxCount + " раз)");
        else System.out.println("В массиве чаще всего встречается элемент " + (maxElem - 1) +  " (" + maxCount + " раз)");

    } // end psvm

    // посмотреть Arrays.copyOf;
    // почитать про быструю сортировку
    // почитать про бинарный поиск
}
