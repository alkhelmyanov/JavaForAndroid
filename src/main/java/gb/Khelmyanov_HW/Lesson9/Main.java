package gb.Khelmyanov_HW.Lesson9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] array = {{"1", "Д", "3", "4"}, {"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            MySumArray.sumArray(array);

            // Поймана ошибка. Обработана выдав сообщение, и обрезав массив до нужных значений.
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage() + ". Массив сокращен до размера 4 на 4");
            array = Arrays.copyOfRange(array, 1, 5);
            MySumArray.sumArray(array);

        } //catch (MyArrayDataException e) {
        //  e.printStackTrace();
//}


    }

}

class MySumArray {
    public static void sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int outArray = array.length;
        int inArray = array[0].length;
        System.out.println("Массив: " + outArray + " " + inArray);

        if (array.length <= 4 && array[0].length <= 4) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            throw new MyArraySizeException("Величина массива не может быть больше 4х элементов");
        }

        /*int summator = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                summator += array[i][j];
            }
            System.out.println();
        }*/
    }

}
