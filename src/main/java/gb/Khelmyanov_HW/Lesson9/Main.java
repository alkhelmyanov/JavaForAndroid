package gb.Khelmyanov_HW.Lesson9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MyArrayDataException {

        String[][] arrayStr = {{"1", "2", "3", "4"}, {"1", "Д", "3", "4"}, {"5", "6", "F", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};


        do {
            MySumArray.checkStatus = 0;
            try {
                MySumArray.sumArray(arrayStr);
            } catch (MyArrayDataException e) {
                int i = Integer.parseInt(arrayStr[e.getX()][e.getY() - 1]);
                int j = Integer.parseInt(arrayStr[e.getX()][e.getY() + 1]);
                arrayStr[e.getX()][e.getY()] = String.valueOf(i + j / 2);
            }
        } while (MySumArray.checkStatus == 1);
    }
}

class MySumArray {

    static int checkStatus = 0;

    public static void sumArray(String[][] arrayStr) throws MyArrayDataException {

        int tempForSum = 0;

        int outArray = arrayStr.length;
        int inArray = arrayStr[0].length;

        System.out.println("Массив: " + outArray + " " + inArray);
        MySumArray mySumArray = new MySumArray();
        int[][] arrayInt = new int[4][4];

        try {
            for (int i = 0; i < arrayStr.length; i++) {
                for (int j = 0; j < arrayStr[i].length; j++) {
                    System.out.print(arrayStr[i][j] + " ");
                }
                System.out.println();
            }

            // Поймана ошибка. Выдано исключение.
            if (arrayStr.length > 4 || arrayStr[0].length > 4) {
                throw new MyArraySizeException("\nИсключение MyArraySizeException. Массив не может быть размером больше чем 4 на 4");
            }

            // Не предоставляем возможность другому человеку исправить, обрезаем массив сами.
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage() + ". \nВаш массив обрезан с конца до размера 4 на 4\n");
            arrayStr = Arrays.copyOfRange(arrayStr, 0, 4);
            MySumArray.sumArray(arrayStr);
        }

        // Выбрасываем исключение и просим пользователя самого изменить массив

        for (int i = 0; i < arrayStr.length; i++) {
            for (int j = 0; j < arrayStr[i].length; j++) {
                try {
                    // System.out.println("i = " + i + " j = " + j);
                    int strForInt = Integer.parseInt(arrayStr[i][j]);
                    arrayInt[i][j] = strForInt;
                    tempForSum += strForInt;

                } catch (NumberFormatException e) {
                    //System.out.println(e.getMessage() + " Исключение");

                    checkStatus = 1;
                    throw new MyArrayDataException("Исключение MyArrayDataException", i, j, arrayStr[i][j]);
                }
            }
        }

        System.out.println("Обновленный массив " + Arrays.deepToString(arrayInt));
        System.out.println("Сумма элементов равна :" + tempForSum);

    }

// 1. как после поимки первого исключения, продолжить работу, менять тип на int и добраться до следующего неправильного значения?

    //  System.out.println("Сумма элементов массива равна " + tempForSum);

            /*int summator = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    summator += array[i][j];
                }
                System.out.println();
            }*/

}
