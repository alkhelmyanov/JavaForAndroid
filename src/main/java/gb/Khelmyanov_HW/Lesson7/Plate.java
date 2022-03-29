package gb.Khelmyanov_HW.Lesson7;

public class Plate {

    private int food;
    private String featureOfPlate; // особенность миски
    private final int capacityOfPlate;
    boolean satiety;

    public Plate(String featureOfPlate, int capacityOfPlate, int food) {
        this.food = food;
        this.featureOfPlate = featureOfPlate;
        this.capacityOfPlate = capacityOfPlate;
    }

    public void addFoodToPlate(int quantity) {
        System.out.printf("В миску добавили %d гр. корма, ", quantity);
        if (food + quantity > capacityOfPlate) {
            System.out.println("миска переполнилась, и из нее просыпалось " + ((food + quantity) - capacityOfPlate) + " гр.");
            food = capacityOfPlate;
        } else if (food + quantity == capacityOfPlate) {
            System.out.println("теперь миска наполнена до краев");
        } else {
            food = food + quantity;
            System.out.println("теперь в миске " + food + " гр. корма");
        }
    }

    public boolean decreaseFood(int appetite, String name) {
        System.out.printf("Кот по имени %s, пошел покушать, его аппетит %d гр.\n", name, appetite);
        if (food - appetite >= 0) {
            food -= appetite;
            System.out.println("В тарелке \"" + featureOfPlate + "\" осталось " + food + " гр.");
            return true;
        } else {
            System.out.println("В тарелке \"" + featureOfPlate + "\" не хватает еды (в тарелке " + food + " гр.). Похоже кот " + name + " останется голодным.");
            return false;
        }
    }

    public void plateInfo() {
        System.out.println("plate: " + food);
    }
}
