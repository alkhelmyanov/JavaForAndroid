package gb.Khelmyanov_HW.Lesson11.Task3;

public class Apple extends Fruit implements FruitInterface {

    int weight;

    public Apple(int weight) {
        this.weight = weight;

        System.out.println("С ветки сорвали Яблоко " + weight + "гр.");
    }

    @Override
    public String toString() {
        return "Яблоко " + weight +
                "гр.";
    }

    @Override
    public int getFruitWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return "Яблоко";
    }
}
