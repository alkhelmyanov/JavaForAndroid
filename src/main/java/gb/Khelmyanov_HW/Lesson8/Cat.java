package gb.Khelmyanov_HW.Lesson8;

public class Cat extends Action implements Runner{

    String name;
    String typeOfRunner = "Кот";

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        methodRun(typeOfRunner, name);

    }

    @Override
    public void jump() {
        methodJump(typeOfRunner, name);
    }
}
