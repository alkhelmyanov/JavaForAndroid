package gb.Khelmyanov_HW.Lesson11.Task1;

import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayListInt = new ArrayList<>();
        Collections.addAll(arrayListInt, 1, 2, 3, 4, 5, 6, 7);

        ArrayList<String> arrayListStr = new ArrayList<>();
        Collections.addAll(arrayListStr, "Саша", "Маша", "Галя", "Валя", "Глаша");

        ArrayList<Object> arrayListObj = new ArrayList<>();
        Collections.addAll(arrayListObj, arrayListInt, arrayListInt, arrayListStr, arrayListStr);

        ArrrayTask arrrayTask = new ArrrayTask();
        arrrayTask.changeArrayElementsPosition(arrayListInt, 1, 7);
        arrrayTask.changeArrayElementsPosition(arrayListStr, 1, 2);
        arrrayTask.changeArrayElementsPosition(arrayListObj, 1, 2);
    }


}

