package gb.Khelmyanov_HW.Lesson8;

public class Main {
    public static void main(String[] args) {

        Runner cat = new Cat("Барсик");
        Runner robot = new Robot("Робинович");
        Runner human = new Human("Тимофей");

        Wall.setHeight(10);
        RunningTrack.setDistance(500);

        //Runner [] runners = new Runner[3];
        Runner [] runners = {cat, robot, human};

        for (int i = 0; i < runners.length; i++) {
            runners[i].run();
            runners[i].jump();
        }

    }
}
