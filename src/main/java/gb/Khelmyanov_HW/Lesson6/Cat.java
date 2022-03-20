package gb.Khelmyanov_HW.Lesson6;

public class Cat extends Animal {

    public static int catCounter = 0;

    public Cat(String name) {
        super(name);

        catCounter++;
    }

    public void animalCounter() {
        System.out.println("\nКол-во созданных котов " + catCounter);
    }

    public void animalRun(int distance) {
        if (distance <= 200) {
            System.out.printf("Кот с именем %s пробежал %dм\n", name, distance);
        } else {
            System.out.println("Кот больше 200 м пробежать не может");
        }
    }

    public void animalSwim(int distance) {
        System.out.printf("Коты не умеют плавать, не бросайте их в воду, иначе ваш кот %s утонет\n", name);
    }

}
