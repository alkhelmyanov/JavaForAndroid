package gb.Khelmyanov_HW.Lesson9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[][] array = {{"1", "2", "3", "4"}, {"1", "Д", "3", "4"}, {"5", "6", "F", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};


        try {
            MySumArray.sumArray(array);
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }

    }

}

class MySumArray {
    public static void sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int tempForSum = 0;

        int outArray = array.length;
        int inArray = array[0].length;
        System.out.println("Массив: " + outArray + " " + inArray);

        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }

            // Поймана ошибка. Выдано исключение.
            if (array.length > 4 || array[0].length > 4) {
                throw new MyArraySizeException("Исключение MyArraySizeException. Массив не может быть размером больше чем 4 на 4");
            }

            // Не предоставляем возможность другому человеку исправить, обрезаем массив сами.
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage() + ". \nВаш массив обрезан с конца до размера 4 на 4\n");
            array = Arrays.copyOfRange(array, 0, 4);
            MySumArray.sumArray(array);
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    System.out.println("i = " + i + " j = " + j);

                    int temp = Integer.parseInt(array[i][j]);

                    throw new MyArrayDataException("Исключение MyArrayDataException");
                } catch (MyArrayDataException e) {
                    e.getMessage();

                }
            }
        }
        System.out.println("Выполнение программы завершено");

        //  System.out.println("Сумма элементов массива равна " + tempForSum);

            /*int summator = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    summator += array[i][j];
                }
                System.out.println();
            }*/
    }

}
