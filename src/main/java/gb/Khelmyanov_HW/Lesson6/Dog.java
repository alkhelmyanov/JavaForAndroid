package gb.Khelmyanov_HW.Lesson6;

public class Dog extends Animal {
   static int dogCounter = 0;

    public Dog(String name) {
        super.name = name;

        dogCounter++;
    }

    public void dogCounter() {
        System.out.println("Счетчик собак " + dogCounter);
    }

    @Override
    public void animalInfo() {
        System.out.println("Собака с именем " + name);
    }

    public void animalRun(int distance) {
        if (distance <= 500) {
            System.out.printf("Собака по имени %s пробежала %dм\n", name, distance);
        } else {
            System.out.println("Собака больше 500м пробежать не может");
        }
    }

    public void animalSwim(int distance) {
        if (distance <= 10) {
            System.out.printf("Собака по имени %s проплыла %dм\n", name, distance);
        } else {
            System.out.println("Тренируйте собаку больше, она пока не может проплыть больше 10м");
        }
    }
}
