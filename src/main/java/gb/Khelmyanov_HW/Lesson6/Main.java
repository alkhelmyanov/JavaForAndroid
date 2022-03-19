package gb.Khelmyanov_HW.Lesson6;

public class Main {
    String name;
    int catCounter = 0;

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

        catCounter();
        dogCounter();
        System.out.println("Кол-во кошек ");

    }

}
