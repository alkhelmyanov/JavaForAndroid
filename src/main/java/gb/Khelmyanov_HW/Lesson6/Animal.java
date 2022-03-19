package gb.Khelmyanov_HW.Lesson6;

public class Animal {

    protected String name;
    private int distance;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public Animal(){

    }

    public Animal(String name) {
        this.name = name;

        counter++;
    }

    public void animalRun(int distance, Animal animal) {
        System.out.println("Животное пробежало " + distance + "м");
    }

    public void animalSwim(int distance, Animal animal) {
        System.out.println("Животное проплыло " + distance + "м");
    }

    public static void main(String[] args) {

        Cat cat01 = new Cat("Барсик");
        Cat cat02 = new Cat("Персик");
        Cat cat03 = new Cat("Чертик");

        Dog dog01 = new Dog("Бобик");
        Dog dog02 = new Dog("Тузик");

        cat01.animalRun(200);
        cat02.animalSwim(100);

        dog01.animalRun(499);
        dog01.animalSwim(300);

    }
}
