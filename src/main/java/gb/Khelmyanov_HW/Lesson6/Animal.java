package gb.Khelmyanov_HW.Lesson6;

public class Animal {

    protected String name;
    protected int distance;
    private static int animalCounter = 0;

    public int getAnimalCounter() {
        return animalCounter;
    }

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;

        animalCounter++;
    }

    public void animalAction(int distance, Animal animal) {
        if (animal instanceof Dog) {
            ((Dog) animal).animalRun(200);
        }
        if (animal instanceof Cat) {
            ((Cat) animal).animalRun(100);
        }
    }

    public void animalCounter() {
        System.out.println("\nВсего животных " + getAnimalCounter());
    }

    public void animalRun(int distance) {
        System.out.println("Животное пробежало " + distance + "м");
    }

    public void animalSwim(int distance) {
        System.out.println("Животное проплыло " + distance + "м");
    }

}
