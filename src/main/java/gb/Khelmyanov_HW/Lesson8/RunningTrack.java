package gb.Khelmyanov_HW.Lesson8;

import java.util.Random;


public class RunningTrack implements Obstruction {

    private static int distanceOfTrack;

    public static void setDistanceOfTrack(int distanceOfTrack) {
        RunningTrack.distanceOfTrack = distanceOfTrack;
    }

    public static int getRunnerDistance() {
        return runnerDistance;
    }

    public static void setRunnerDistance(int runnerDistance) {
        RunningTrack.runnerDistance = runnerDistance;
    }

    private static int runnerDistance;

    public static int getDistanceOfTrack() {
        return distanceOfTrack;
    }

    Random random = new Random();

    public void setDistance(int distance) {
        RunningTrack.distanceOfTrack = distance;
    }


    // Метод который рассчитывает длину отрезка линии
    @Override
    public void calculateObstruction() {
        setDistance(random.nextInt(3) + 100);
    }

    // Метод, который придумывает выносливость игрока на забег. В зависимости от типа им добавляется одна сверхвозможность.
    public static int calculateEndurance(String typeOfRunners, String name) {
        Random random = new Random();
        int superPower = random.nextInt(5);
        int randomNumber = random.nextInt(5);
        if (superPower == randomNumber) {
            setRunnerDistance(200);
            System.out.println("Участник получили супер силу, выносливость выросла до 200, прыжок, и он уже у следующего препятствия!!!");
        } else {
            setRunnerDistance(random.nextInt(5) + 100);
            System.out.printf("Выносливость бегуна \"%s\" по имени %s в беге равна %d\n", typeOfRunners, name, getRunnerDistance());
        }
        return getRunnerDistance();
    }

    // Просто метод который проверял может ли пройти препятствие бегун
    /*  public static void methodRun(String typeOfRunner, String name, int runnerDistance) {
        if (runnerDistance <= obstructionArrayIndex) {
            System.out.println(typeOfRunner + " по имени \"" + name + "\" не может пробежать больше 500м");
        } else {
            System.out.println(typeOfRunner + " то имени \"" + name + "\" пробежал участок " + "м");
        }
    }*/
}
