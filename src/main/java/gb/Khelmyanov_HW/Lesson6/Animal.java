package gb.Khelmyanov_HW.Lesson6;

public class Animal {

    String name;
    int distance;
    int counter;

    public int getCounter() {
        return counter;
    }

    public Animal(){

    }

    public Animal(String name, int distance){

        this.name = name;
        this.distance = distance;

        counter ++;
    }

    public void animalInfo(){
        System.out.println("Животное с именем " + name);
    }

    public void animalRun(int distance) {
        System.out.println("Животное пробежало " + distance + "м");
    }

    public void animalSwim(int distance) {
        System.out.println("Животное проплыло " + distance + "м");
    }

}
