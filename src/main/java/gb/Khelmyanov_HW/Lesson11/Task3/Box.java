package gb.Khelmyanov_HW.Lesson11.Task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    String name;
    T fruit;

    ArrayList<T> arrayList = new ArrayList<>();

    public Box(String name) {
        this.name = name;

        System.out.println("Сколотили " + name);
    }

    public Box(String name, T fruit) {

        this.name = name;
        this.fruit = fruit;

        System.out.println("Сколотили " + name + " и положили в нее " + fruit);

    }

    public void addFruit(T fruit) {
        if (fruit instanceof Apple) {
            System.out.println("В коробку положили " + fruit);
            arrayList.add(fruit);
            System.out.printf("В коробке лежит Яблок: %d \n", arrayList.size());

            //System.out.println(arrayList);
        } else {
            System.out.println("В коробку положили " + fruit);
            arrayList.add(fruit);
            System.out.printf("В коробке лежит Апельсинов: %d \n", arrayList.size());
            //System.out.println(arrayList);
        }
    }

    public void getWeight() {
        int boxWeight = 0;
        for (T array : arrayList) {

            boxWeight += array.weight;

        }

        System.out.println("Вес яблок в коробке " + boxWeight + "гр.");
    }


}
