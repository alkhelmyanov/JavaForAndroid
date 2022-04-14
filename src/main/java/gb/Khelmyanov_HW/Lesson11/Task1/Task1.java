package gb.Khelmyanov_HW.Lesson11.Task1;

import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayListInt = new ArrayList<>();
        Collections.addAll(arrayListInt, 1, 2, 3, 4, 5, 6, 7);

        ArrayList<String> arrayListStr = new ArrayList<>();
        Collections.addAll(arrayListStr, "Саша", "Маша", "Галя", "Валя", "Глаша");

        System.out.println(arrayListInt);
        System.out.println(arrayListStr);

        ArrrayTask arrrayTask = new ArrrayTask();
        arrrayTask.changeArrayElementsPosition(arrayListInt, 2, 3);
        arrrayTask.changeArrayElementsPosition(arrayListStr,2,3);
    }


}

class ArrrayTask {

    public static <T> void changeArrayElementsPosition(ArrayList<T> arrayList, Integer Element1, Integer Element2) {

        Collections.swap(arrayList,Element1, Element2);
        System.out.println(arrayList);

    }
}