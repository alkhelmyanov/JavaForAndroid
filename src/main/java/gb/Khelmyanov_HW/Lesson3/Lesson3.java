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
        //gameChoise();
        //checkOfNumberBalance();
        //endOfGame();

        //emptyArray();
        //wordsArray();
        //wordsToChar();

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
            int choice = inputOfHumanInt();
            switch (choice) {
                case 0 -> {
                    f = false;
                    System.out.print("Спасибо что заглянули к нам.\nБудем рады видеть Вас снова!!!");
                    scanner.close();
                }
                case 1 -> guessTheNumber();
                case 2 -> guessTheWord();
                default -> System.out.println("К сожалению других игр пока нет :(");
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
            int human = inputOfHumanInt();
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
        endOfGame(1);

    }

    //endregion

    //region Тело игры "Угадай слово"
    private static void guessTheWord() {
        System.out.println("\n=================================");
        System.out.println("Вы запустили игру угадай Слово");
        System.out.print("===================================");
        System.out.println("\nПопробуйте угадать название фрукта или овоща, который загадал компьютер.");
        System.out.print("------------------------------------");

        // Загаданное с помощью Random компьютером слово
        String computerStep = selectWordsFromArray();
        //System.out.print("Компьютер загадал слово: ");
        //System.out.println(computerStep);

        // Заполняем computerEmptyArray словом которое придумал компьютер
        char[] computerEmptyArray = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
        for (int i = 0; i < computerStep.length(); i++) {
            char charFromComputerWord = wordsToChar(i, computerStep);
            computerEmptyArray[i] = charFromComputerWord;
        }
        //System.out.println(computerEmptyArray);
        char[] humanEmptyArray;
        char[] additionalArray;
        int countOfMistake = 0;
        int countOfAttempt = 0;
        // Предположительно этот пустой сканнер отчищает поле. Без него первым вводится пустое слово.
        scanner.nextLine();

        do {
            // Игрок вводит свое слово и заполняется этим словом массив humanEmptyArray
            countOfMistake = 0;

            humanEmptyArray = new char[]{'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
            System.out.print("\nВведите название предполагаемого фрукта: ");

            String humanStep = inputOfHumanString();
            for (int i = 0; i < humanStep.length(); i++) {
                char charFromHumanWord = wordsToChar(i, humanStep);
                humanEmptyArray[i] = charFromHumanWord;
            }
            //System.out.println(humanEmptyArray);

            //Создается дополнительный массив в который посимвольно записывается результат сравнения слова человека и компьютера

            additionalArray = new char[]{'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
            for (int i = 0; i < 15; i++) {
                if (computerEmptyArray[i] == humanEmptyArray[i]) {
                    additionalArray[i] = computerEmptyArray[i];
                } else {
                    countOfMistake++;
                }
            }
            //System.out.println("Кол-во ошибок:" + countOfMistake);
            //System.out.print("Ответ игрока: ");
            //System.out.println(humanEmptyArray);
            //System.out.print("Загаданное компьютером словом: ");
            //System.out.println(computerEmptyArray);
            System.out.print("\nСовпавшие буквы загаданного слова: ");
            System.out.println(additionalArray);

            countOfAttempt++;
            //System.out.println("Попытка: " + countOfAttempt);

            //Сделанна маленькая подсказка если совсем туго угадывается
            switch (countOfAttempt) {
                case 3 -> System.out.println("Подсказка!!! 1я буква загаданного слова: " + computerEmptyArray[0]);
                case 5 -> System.out.println("Подсказка!!! 3я буква загаданного слова: " + computerEmptyArray[2]);
                case 7 -> System.out.println("Подсказка!!! 5я буква загаданного слова: " + computerEmptyArray[4]);
            }


        } while (countOfMistake > 0);
        System.out.println("\n!!! Поздравляем, вы угадали слово c " + countOfAttempt + " попытки!!!");
        endOfGame(2);
    }

    //endregion

    // region Метод endOfGame завершающий игру и предлагающий ее либо продолжить либо выйти в главное меню
    private static void endOfGame(int numberOfGame) {
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
            switch (numberOfGame) {
                case 1 -> guessTheNumber();
                case 2 -> guessTheWord();
            }
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
    private static int inputOfHumanInt() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Вы ввели некорректное число или выпадающее из диапазона");
            scanner.nextLine();
        }
        return -1;
    }

    private static String inputOfHumanString() {
        return scanner.nextLine();
    }


    //endregion
    //region Ход компьютера через Random
    private static int computerRandom() {
        //System.out.println("\nКомпьютер придумал число: " + computerRandom);
        return random.nextInt(10);
    }

    //endregion


    //region Метод который возвращает случайно выбранное слово из массива слов
    private static String selectWordsFromArray() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int selectWordCount = random.nextInt(words.length);
        return words[selectWordCount];
    }

    //endregion
    //region Этот метод принимает порядковый номер символа и слово которое надо разобрать на символы
    private static char wordsToChar(int indexOfLetter, String strWord) {
        return strWord.charAt(indexOfLetter);
        //System.out.println("Индекс i: " + indexOfLetter + "     " + a + "     ");
        //indexOfLetter++;

    }
}


/*
Общие проблемы:
После окончания игры, если выходить через "0" из игры в главное меню, а потом так же через "0" из игры вообще, выдает ошибку.

Игра "Угадай число".
1. Обработать ошибку ввода букв вместо чисел. Засчитывает как несколько ходов.

Игра "Угадай слово".
1. Обработать ошибку когда слово больше 15 символов.
2. Сделать выход из игры, если надоест угадывать.
3. Каждый раз после ввода слова список букв перезаписывается.
*/


