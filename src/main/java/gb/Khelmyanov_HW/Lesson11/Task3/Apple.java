package gb.Khelmyanov_HW.Lesson11.Task3;

public class Apple extends Fruit{

    int weight;

    public Apple(int weight) {
        this.weight = weight;

        System.out.println("С ветки сорвали Яблоко " + weight + "гр.");
    }

    @Override
    public String toString() {
        return "Яблоко "+ weight +
                "гр.";
    }
}
