package gb.Khelmyanov_HW.Lesson7;

public class Cat {

    private String name;
    public int appetite;
    protected boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
        System.out.println("Это кот \"" + name + "\". Сытость кота: " + satiety);
    }

    public void eat(Plate plate) {
        if (!satiety) {
            System.out.println("Сытость кота: " + plate.decreaseFood(appetite, name));
        } else {
            System.out.println("Кот " + name + " сытый");
        }
    }

    public void catInfo() {
        //System.out.println("У кота " + name + " сытость " + satiety);
    }
}
