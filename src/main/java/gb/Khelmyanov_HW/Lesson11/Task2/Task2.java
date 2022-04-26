package gb.Khelmyanov_HW.Lesson11.Task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        Integer[] arraysInt = {1, 2, 3, 4, 5, 6, 7};
        String[] arraysStr = {"Саша", "Маша", "Галя", "Валя", "Глаша"};


        ArraytoArrayList arrayList = new ArraytoArrayList();
        System.out.println(arrayList.arraysToArrayListMethod(arraysInt));
        System.out.println(arrayList.arraysToArrayListMethod(arraysStr));

    }

}




