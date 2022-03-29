package gb.Khelmyanov_HW.Lesson8;

public class Robot implements Runner {
    String name;
    String typeOfRunner = "Робот";

    public Robot(String name) {
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
