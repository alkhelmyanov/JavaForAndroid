package gb.Khelmyanov_HW.Lesson7;

import java.util.Random;

public class Cat {

    private String name;
    public int appetite;
    protected boolean satiety;

    Random random = new Random();

    public Cat(String name) {

        appetite = random.nextInt(30);
        this.name = name;

        satiety = false;
        System.out.println("Это кот \"" + name + "\". Емкость живота " +appetite+ "гр. Сытость кота: " + satiety);
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
