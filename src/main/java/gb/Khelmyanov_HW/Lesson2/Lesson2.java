package gb.Khelmyanov_HW.Lesson2;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {

        // Задание №1.
        System.out.println("Задание №1. Вариант с использванием if/else.");
        invertArray1();
        System.out.println();

        System.out.println("Задание №1. Вариант с использванием Switch.");
        invertArray2();
        System.out.println();

        // Задание №2.
        System.out.println("Задание №2. Заполнение массива значениями с помощью цикла и вспомогательной переменной.");
        fillArray();
        System.out.println();

        System.out.println("Задание №2. Заполнение массива значениями с помощью 2х переменных в цикле");
        fillArray2();
        System.out.println();

        System.out.println("Задание №3. Поиск в массиве значений меньше 6 и умножение их на 2");
        changeArray();
        System.out.println();

        fillDiagonal();
    }


    //region Практическое задание №1. Замена элементов массива с использванием if/else.

    private static void invertArray1() {
        int[] arr = {1, 1, 0, 0, 0, 1, 0, 1, 1};
        System.out.println("Исходный массив:     " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Массив после замены: " + Arrays.toString(arr));

    }
    //endregion
    //region Практическое задание №1. Замена элементов с использованием Switch.

    private static void invertArray2() {
        int[] arr = {1, 1, 0, 0, 0, 1, 0, 1, 1};
        System.out.println("Исходный массив:     " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
            }
        }
        System.out.println("Массив после замены: " + Arrays.toString(arr));
    }
    //endregion
    // region Практическое задание №2. Заполнение массива значениями с помощью цикла и вспомогательной переменной

    private static void fillArray() {
        int[] arr = new int[8];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = j;
            j += 3;
        }
        System.out.println(Arrays.toString(arr));
    }
    //endregion
    //region Практическое задание №2. Заполнение массива значениями с помощью 2х переменных в цикле

    private static void fillArray2() {
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));
    }
    //endregion
    // region Практическое задание №3. Поиск в массиве значений меньше 6 и умножение их на 2.

    private static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println("Изменный массив: " + Arrays.toString(arr));
    }

    //endregion

    private static void fillDiagonal() {
        int[][] arr = {{1,2,4,5,6,4}, {1,3,1,2,1,3}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr [i][j]);
            }
            System.out.println();
        }

    }
}
