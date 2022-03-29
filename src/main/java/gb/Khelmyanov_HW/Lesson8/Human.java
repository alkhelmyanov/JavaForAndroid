package gb.Khelmyanov_HW.Lesson8;

public class Human implements Runner {
    String name;
    String typeOfRunner = "Человек";

    public Human(String name) {
        this.name = name;
    }

    public int run() {
        return RunningTrack.calculateEndurance(typeOfRunner, name);

        //RunningTrack.methodRun(typeOfRunner, name, runnerDistance);
    }

    @Override
    public int jump() {
        return Wall.calculateEndurance(typeOfRunner, name);
    }
}
