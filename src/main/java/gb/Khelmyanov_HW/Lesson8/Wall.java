package gb.Khelmyanov_HW.Lesson8;

import java.util.Random;

public class Wall implements Obstruction {

    protected static int height;

    public static int getRunnerHeight() {
        return RunnerHeight;
    }

    public static void setRunnerHeight(int runnerHeight) {
        RunnerHeight = runnerHeight;
    }

    protected static int RunnerHeight;

    public static int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        Wall.height = height;
    }

    Random random = new Random();

    // Метод который рассчитывает высоту стены

    @Override
    public void calculateObstruction() {
        setHeight(random.nextInt(3) + 10); // Почему не записать так, число до 3, и к нему прибавляется 10?
    }

    // Метод, который придумывает выносливость игрока на прыжок
    public static int calculateEndurance(String typeOfRunners, String name){
        Random random = new Random();
        setRunnerHeight(random.nextInt(3) + 10);
        System.out.printf("Выносливость бегуна \"%s\" по имени %s в прыжке равна %d\n", typeOfRunners, name, getHeight());
        return getHeight();
    }

    // Просто метод который проверял может ли пройти препятствие бегун
    /*public static void methodJump(String typeOfRunner, String name) {
        if (Wall.getHeight() > 15) {
            System.out.println(typeOfRunner + " не может перелезть препятствие выше 15м, боится убиться!!!");
        } else {
            System.out.println(typeOfRunner + " перелез стену " + Wall.getHeight() + "м");
        }
    }*/
}
