package gb.Khelmyanov_HW.Lesson6;

public class Main extends Animal {
    public static void main(String[] args) {

        Cat cat01 = new Cat("Барсик");
        Cat cat02 = new Cat("Персик");
        Cat cat03 = new Cat("Чертик");

        Dog dog01 = new Dog("Бобик");
        Dog dog02 = new Dog("Тузик");
        Dog dog03 = new Dog("Тусик");

        Animal cat04 = new Cat("Макс");
        Animal dog04 = new Dog("Макс2");

        cat01.animalCounter();
        cat01.animalRun(100);
        cat01.animalSwim(200);
        cat02.animalRun(50);
        cat02.animalSwim(10);

        dog01.dogCounter();
        dog01.animalRun(500);
        dog01.animalSwim(40);

        dog04.animalCounter();

    }
}
