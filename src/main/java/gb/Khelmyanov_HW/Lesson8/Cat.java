package gb.Khelmyanov_HW.Lesson8;

import java.util.Random;

public class Cat implements Runner{

    String name;
    String typeOfRunner = "Кот";
    int runnerDistance;
    int height;

    public Cat(String name) {
        this.name = name;


    }

    @Override
    public int run() {
       return RunningTrack.calculateEndurance(typeOfRunner, name);

       //RunningTrack.methodRun(typeOfRunner, name, runnerDistance);
    }

    @Override
    public int jump() {
        return Wall.calculateEndurance(typeOfRunner, name);
    }
}
