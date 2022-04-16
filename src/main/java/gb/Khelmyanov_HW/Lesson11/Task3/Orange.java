package gb.Khelmyanov_HW.Lesson11.Task3;

public class Orange extends Fruit {
    int weight;

    public Orange(int weight) {
        this.weight = weight;

        System.out.println("С ветки сорвали Апельсин " + weight + "гр.");
    }

    @Override
    public String toString() {
        return "Апельсин "+ weight +
                "гр.";
    }
}
