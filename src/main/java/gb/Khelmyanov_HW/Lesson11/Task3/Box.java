package gb.Khelmyanov_HW.Lesson11.Task3;

import java.util.ArrayList;

public class Box<T extends FruitInterface> {

    String name;
    T fruit;
    int boxWeight = 0;

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
            System.out.println("В коробку добавили " + fruit);
            arrayList.add(fruit);
            // System.out.printf("В коробке лежит Яблок: %d \n", arrayList.size());
            //System.out.println(arrayList);
        } else {
            System.out.println("В коробку добавили " + fruit);
            arrayList.add(fruit);
            //System.out.printf("В коробке лежит Апельсинов: %d \n", arrayList.size());
            //System.out.println(arrayList);
        }
        System.out.printf("В коробке лежит %s: %d \n", fruit.getName(), arrayList.size());
    }

    public int getWeight() {
        boxWeight = 0;
        for (T array : arrayList) {
            boxWeight += array.getFruitWeight();
        }
        System.out.printf("В %s положили %dгр. ов \n", name, boxWeight/*, arrayList.get(1).getName()*/);
        return boxWeight;
    }

    public boolean compare(Box<?> compareBox) {
        System.out.println("коробка 1 для cравнения " + boxWeight);
        System.out.println("коробка 2 для cравнения " + compareBox.boxWeight);
        return boxWeight == compareBox.boxWeight;
    }

    public void transferFruit(Box<T> fullBox) {
        fullBox.arrayList.addAll(arrayList);
        arrayList.removeAll(arrayList);
    }
}


