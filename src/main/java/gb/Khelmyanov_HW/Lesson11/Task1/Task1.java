package gb.Khelmyanov_HW.Lesson11.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayListInt = new ArrayList<>();
        Collections.addAll(arrayListInt, 1, 2, 3, 4, 5, 6, 7);

        ArrayList<String> arrayListStr = new ArrayList<>();
        Collections.addAll(arrayListStr, "Саша", "Маша", "Галя", "Валя", "Глаша");

        ArrayList<Object> arrayListObj  = new ArrayList<>();
        Collections.addAll(arrayListObj, arrayListInt,arrayListInt,arrayListStr,arrayListStr );

        System.out.println(arrayListInt);
        System.out.println(arrayListStr);
        System.out.println(arrayListObj);

        ArrrayTask arrrayTask = new ArrrayTask();
        arrrayTask.changeArrayElementsPosition(arrayListInt, 2, 3);
        arrrayTask.changeArrayElementsPosition(arrayListStr,2,3);
        arrrayTask.changeArrayElementsPosition(arrayListObj,1,2);
    }


}

class ArrrayTask {

    // СНачала описывал сложно сам, а потом оказалось что есть стандартный метод через swap
    public static <T> void changeArrayElementsPosition(ArrayList<T> arrayList, Integer Element1, Integer Element2) {

        final ArrayList <T> ORIGINALARRAYLIST = arrayList;
        System.out.println("Оригинальная коллекция: " + ORIGINALARRAYLIST);

        arrayList.set(Element1, arrayList.set(Element2, arrayList.get(Element1)));
        System.out.println("Измененная коллекция: " + arrayList);

    }

}