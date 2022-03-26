package gb.Khelmyanov_HW.Lesson8;

public class Human extends Action implements Runner {
    String name;
    String typeOfRunner = "Человек";

    public Human(String name) {
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
