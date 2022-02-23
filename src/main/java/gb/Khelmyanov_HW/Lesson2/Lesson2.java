package gb.Khelmyanov_HW.Lesson2;

import java.util.Arrays;
import java.util.Random;

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

        System.out.println("Задание №4. Заполнение диагоналей квадратного массива единицами");
        fillDiagonal(20); // Передайте в парраметры размер квадрата
        System.out.println();

        System.out.println("Задание №5. Нахождение минимального и максимального элемента массива");
        findMinMaxElements();
        System.out.println();

        System.out.println("\nЗадание №6. Нахождение баланса в массиве по простому");
        System.out.println("Массив сбалансирован: " + checkBalance());
        System.out.println();

        System.out.println("\nЗадание №6. Нахождение баланса в массиве с подсчетом и циклами");
        System.out.println("Массив сбалансирован: " + checkBalanceV2());
        System.out.println();
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
    // region Практическое задание №4. Заполнение диагоналей квадратного массива единицами
    private static void fillDiagonal(int arrSize) {

        int[][] arr = new int[arrSize][arrSize];
        int count = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i] == arr[j] || j == count) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j]);
            }
            count -= 1;
            System.out.println();
        }
    }

    //endregion.
    // region Практическое задание №5. Нахождение минимального и максимального элемента массива
    private static void findMinMaxElements() {
        Random random = new Random();
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Сгенерирован случайный массив: \n" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Массив случайных чисел отсортирован от меньшего к большему: \n" + Arrays.toString(arr));
        System.out.printf("Минимальное значение массива: %d \nМаксимальное значение массива: %d", arr[0], arr[arr.length - 1]);
    }
    //endregion

    private static boolean checkBalance() {
        int[] arr = {2, 4, 8, 1, 2, 2, 7};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        return true;
    }

    private static boolean checkBalanceV2() {
        int[] arr = {2, 4, 8, 1, 2, 2, 7,4};
        int border = 1;
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < border; j++) {
                sumLeft += arr[j];
            }
            for (int j = border; j < arr.length; j++) {
                sumRight += arr[j];
            }
            System.out.printf("Сумм пр.части = %d Суммю л.части = %d\n", sumLeft, sumRight);
            if (sumLeft == sumRight){
                                return true;
                //System.out.println("Обе части равны");
            } else {
                border += 1;
                sumLeft = 0;
                sumRight = 0;
            }
        }return false;
    }

}
