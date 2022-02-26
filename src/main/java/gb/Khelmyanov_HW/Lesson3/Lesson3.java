package gb.Khelmyanov_HW.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // метод с меню для обоих игр
        mainMenu();
        //guessTheNumber();
        //guessTheWord();
        //attemptOfHuman();
        //attemptOfComputer();
        //
        //gameChoise();
        //checkOfNumberBalance();
        //endOfGame();


        // метод с описанием игр
        //discriptionForGames();
        // описание первой игры
        //


    }

    //region  Шапка главного меню. Выбор игр.
    private static void mainMenu() {
        System.out.println("============================");
        System.out.println("       Выберите игру: ");
        System.out.println("-----------------------------");
        System.out.println("    1 - \"Угадай число\"");
        System.out.println("    2 - \"Угадай слово\"");
        System.out.println("-----------------------------");
        System.out.println("0 - выйти из менеджера игр");
        System.out.println("=============================");

        gameChoise();
    }
    //endregion

    // region Метод gameChoise в котором реализована возможность выбора из имеющихся в меню игр
    private static void gameChoise() {

        boolean f = true;
        while (f) {
            System.out.print("Ваш выбор: ");
            int choice = inputOfHuman();
            switch (choice) {
                case 0:
                    f = false;
                    System.out.println("Спасибо что заглянули к нам.\nБудем рады видеть Вас снова!!!");
                    scanner.close();
                    break;
                case 1:
                    guessTheNumber();
                    break;
                case 2:
                    guessTheWord();
                    break;
                default:
                    System.out.println("К сожалению других игр пока нет :(");

            }

        }

    }


    //endregion

    //region Тело игры "Угадай число"
    private static void guessTheNumber() {

        int count = 3;
        boolean isWin = true;

        System.out.print("\n=================================");
        System.out.println("\nВы запустили игру угадай Число");
        System.out.print("===================================");
        System.out.println("\nПопробуйте угадать число которое загадал компьютер от 0 до 9. \nУ вас всего 3 попытки.");
        System.out.print("------------------------------------");
        System.out.print("\nКомпьютер загадал число...");
        int attemptOfComputer = computerRandom(); // сделанна отдельная переменная, чтобы компьютер в цикле не перезагадывал число заново.

        while (isWin && count > 0) {
            System.out.print("\nВаш вариант ответа: ");
            int human = inputOfHuman();
            if (attemptOfComputer == human) {
                System.out.println("\n!!!!!! Поздравляем, вы УГАДАЛИ число !!!!!!");
                isWin = false;
            } else {
                System.out.println("\nК сожалению вы не угадали :( ");
                checkOfNumberBalance(attemptOfComputer, human);
            }
            count--;
        }
        System.out.println("\nЗагаданное компьютером число было: " + attemptOfComputer);
        endOfGame();

    }
    //endregion

    //region Тело игры "Угадай слово"
    private static void guessTheWord() {
        System.out.println("Вы запустили игру угадай Слово");
    }
    //endregion

    // region Метод endOfGame завершающий игру и предлагающий ее либо продолжить либо выйти в главное меню
    private static void endOfGame() {
        System.out.println("\n----------------");
        System.out.println("Игра закончена");
        System.out.print("----------------");

        System.out.print("\n==========================================");
        System.out.print("\nВы хотите повтороить игру:");
        System.out.print("\n\"1\" - если ДА");
        System.out.print("\n\"0\" - если хотите выйти в главное меню");
        System.out.print("\n==========================================");

        System.out.print("\nВаш выбор: ");
        if (scanner.nextInt() == 1) {
            guessTheNumber();
        } else {
            mainMenu();
        }
        scanner.nextInt();
    }
    //endregion

    //region Метод checkOfNumberBalance определяющий баланс числа в игре "Угадай число"
    private static void checkOfNumberBalance(int computerNumber, int humanNumber) {
        if (computerNumber < humanNumber) {
            System.out.println("Число загаданное компьютером меньше чем ваше");
        } else {
            System.out.println("Число загаданное компьютером больше вашего");
        }
    }
    //endregion

    //region Ход пользователя. В нем находится обработка от нежелательных значений.
    private static int inputOfHuman() {
        // int rangeForGameGN = 0;
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Вы ввели некорректное число или выпадающее из диапазона");
            scanner.nextLine();
        }
        return -1;
    }
    //endregion

    //region Ход компьютера через Random
    private static int computerRandom() {
        //System.out.println("\nКомпьютер придумал число: " + computerRandom);
        return random.nextInt(10);
    }
    //endregion


   /* private static void discriptionForGames() {
        String discriptForGameOne;
        String discriptForGameTwo;
    }*/

}
//region
 /*      //Создать массив со словами
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        //Сделать генератор случайных чисел который будет выбирать слово


        //Разбить слово на символы и записать их в новый массив

        //Ввод попытки слова пользователем

        System.out.println("Введите угадываемое слово: ");
        String HumanAttempt = scanner.nextLine();

        //Разбить слово пользователя на символы и записать в новый

        //Создать массив со звездочками
        //Сравннить слово компьютера и пользователя и внести угаданные буквы в массив со звездочками
        //Если все символы совпадают вывести поздравление если нет дать пользователю возможность снова ввести слово
*/
//endregion