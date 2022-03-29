package gb.Khelmyanov_HW.Lesson8;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {


        int numberOfObstacles = 6; // количество препятствий которые должны пройти бегуны

        //Runner cat = new Cat("Барсик");
        //Runner robot = new Robot("Робинович");
       // Runner human = new Human("Тимофей");

        Runner[] runners = {new Cat("Барсик"), new Robot("Робинович"), new Human("Тимофей")};

        Obstruction runningTrack = new RunningTrack(); // создал объекты чтобы запустить нестатический метод.
        Obstruction wall = new Wall();

        //Runner [] runners = new Runner[3];
        //Runner [] runners = {cat, robot, human};

        int[] obstructionArray = new int[numberOfObstacles];


        // массив с полосой препятствий
        for (int i = 0; i < obstructionArray.length; i++) {
            if (i % 2 == 0) {

                // метод с длинной дорожки
                runningTrack.calculateObstruction(); // генерируем случайную длину дорожки
                obstructionArray[i] = RunningTrack.getDistanceOfTrack(); // присваиваем массиву эту длинну
                //System.out.println("Дистанция отрезка = " + RunningTrack.getDistanceOfTrack());
            } else {

                // метод с высотой стены
                wall.calculateObstruction();
                obstructionArray[i] = Wall.getHeight();
                //System.out.println("Высота стены = " + Wall.getHeight());
            }
        }
        //System.out.printf("\nМассив препятствий состоит из %d элементов:\n", numberOfObstacles);
        //System.out.println(Arrays.toString(obstructionArray));

        // Забег
        System.out.println("Мы ведем текстовую трансляцию соревнований");
        System.out.println("В соревновании принимают участие:" + Arrays.toString(runners));
        for (Runner runner : runners) {
            System.out.println("Игрок " + runner + "готов к полосе препятствий: ");
            System.out.println("3\n2\n1\nСтарт!!!\n ");
            for (int i = 0; i < numberOfObstacles; i++) {
                if (i % 2 == 0) {

                    // Испытание №1. Забег по дорожке
                    System.out.println("Длинна дорожки равна " + obstructionArray[i] + "м");
                    if (runner.run() >= obstructionArray[i]) {
                        System.out.println("Участок пути преодолен");
                    } else {
                        System.out.println("Участник выдохся и не смог доползти до конца дорожки");
                        System.out.println("количество пройденных препятствий: " + i );
                        break;
                    }
                } else {

                    // Испытание №2. Прыжок через стену
                    System.out.println("Высота стены " + obstructionArray[i]);
                    if (runner.jump() >= obstructionArray[i]) {
                        System.out.println("Участок пути преодолен");
                    } else {
                        System.out.println("Участник не смог перелезть стену");
                        System.out.println("количество пройденных препятствий: " + i);
                        break;
                    }
                }
                // Продолжение после окончания

            }

        }
    }
}
