package gb.Khelmyanov_HW.Lesson11.Task1;

import java.util.ArrayList;

class ArrrayTask {

    // СНачала описывал сложно сам, а потом оказалось что есть стандартный метод через swap
    //Хотел сделать, чтобы он ловил ошибку IndexOutOfBoundsException и обрабатывал ее, но не получается, не пойму почему.

    public static <T> void changeArrayElementsPosition(ArrayList<T> arrayList, Integer Element1, Integer Element2) {
        System.out.println("\nОригинальная коллекция: " + arrayList);
        try {
            arrayList.set(Element1, arrayList.set(Element2, arrayList.get(Element1)));
            System.out.println("Измененная коллекция: " + arrayList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы хотите поменять местами значения выходящие за пределы массива. Поменяйте свой запрос.");
        }


    }

}
