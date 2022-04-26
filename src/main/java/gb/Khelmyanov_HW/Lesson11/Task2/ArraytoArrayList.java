package gb.Khelmyanov_HW.Lesson11.Task2;

import java.util.ArrayList;

public class ArraytoArrayList<T> {

    public ArrayList<T> arraysToArrayListMethod(T[] arrays) {
        ArrayList<T> arrayList = new ArrayList<>();
        int indexCount = 0;
        for (T array : arrays) {
            arrayList.add(indexCount,array);
            indexCount++;
        }
        //System.out.println(arrayList);
        return arrayList;

    }

}
