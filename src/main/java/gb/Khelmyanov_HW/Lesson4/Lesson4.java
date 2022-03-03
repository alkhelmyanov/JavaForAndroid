package gb.Khelmyanov_HW.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    static String nameOfGame = "Крестики Нолики / tic-tac-toe";

    static final char DOT_HUMAN_1 = 'X';
    static final char DOT_HUMAN_2 = '0';
    static final char DOT_COMPUTER = '0';
    static final char DOT_EMPTY = '▪';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int fieldSizeX;
    static int fieldSizeY;
    static char[][] field;
    static int lineForWin;

    static int[][] fieldForWinCheck;
    static int humanForWinCheck = 7;
    static int computerForWinCheck = 3;

    static char leftUpCorner = '\u2554'; // символ ╔
    static char leftDownCorner = '\u255A'; // символ ╚
    static char rightUpCorner = '\u2557'; // символ ╗
    static char rightDownCorner = '\u255D'; // символ ╝
    static char horizontalLine = '\u2550'; // символ ═
    static char verticalLine = '\u2551'; // символ ║

    static String printLine;


    public static void main(String[] args) {
        //Создать вначале игры меню с Настройками, где будет выбор играть с человеком или компьютером, плюс размер поля, плюс кол-во знаков в ряд для победы.

        mainMenuTicTacToe();
        //renderingMenuOptions();


    }


    // Отрисовка главного меню
    private static void mainMenuTicTacToe() {
        initializeField();
        initializeFieldForWin();

        //Печатаем верхнюю часть меню с названием игры
        System.out.println();
        System.out.print(leftUpCorner);
        for (int i = 0; i < nameOfGame.length() + 2; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightUpCorner);

        printLineWithQuotes(nameOfGame);
        printLineWithQuotes("-----------------------------");
        printLineWithQuotes("  1 - Начать игру            ");
        printLineWithQuotes("  2 - Настройки              ");
        printLineWithQuotes("  0 - Выход из игры          ");
        printLineWithQuotes("-----------------------------");
        //Печать нижней части
        System.out.print(leftDownCorner);
        for (int i = 0; i < nameOfGame.length() + 2; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightDownCorner);
        System.out.print("Ваш выбор: ");

        int mainMenuChoice = scanner.nextInt();
        switch (mainMenuChoice) {
            case 1 -> gameHumanToComputer();
            case 2 -> renderingMenuOptions();
            // case 0 ->
        }
    }

    // Отрисовка меню Настройки
    private static void renderingMenuOptions() {
        System.out.println();
        System.out.print(leftUpCorner);
        for (int i = 0; i < nameOfGame.length() + 6; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightUpCorner);
        printLineWithQuotes("---------------------------------");
        printLineWithQuotes(" 1 - Игра со 2м игроком          ");
        printLineWithQuotes(" 2 - Игра с компьютером          ");
        printLineWithQuotes(" 3 - Размер игрового поля   " + fieldSizeX + " x " + fieldSizeY);
        printLineWithQuotes(" 4 - Длинна победной линии    " + lineForWin + "  ");
        printLineWithQuotes(" 0 - Выйти из настройки          ");
        printLineWithQuotes("---------------------------------");

        //Печатаем нижнюю часть игрового поля
        System.out.print(leftDownCorner);
        for (int i = 0; i < nameOfGame.length() + 6; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightDownCorner);

        runMenuOptions();
    }

    private static void runMenuOptions() {
        System.out.print("Выберете опцию: ");
        int menuOptionsChoice = scanner.nextInt();
        switch (menuOptionsChoice) {
            // case 1 -> ;
            // case 2 -> ;
            case 3:
                System.out.println("Введите размер игрового поля (через пробел): ");
                fieldSizeX = scanner.nextInt();
                fieldSizeY = scanner.nextInt();
                break;
            case 4:
                System.out.print("Введите длину победной линии: ");
                lineForWin = scanner.nextInt();
                break;
            case 0:
                mainMenuTicTacToe();
        }
        renderingMenuOptions();
    }


    // Печать линии с тексом для отрисовки меню
    static void printLineWithQuotes(String line) {
        System.out.print(verticalLine);
        System.out.print(" " + line + " ");
        System.out.println(verticalLine);
    }

    //Проверка на победу
    public static void wincheck() {


    }

    //Иницализация поля для вычисления победы
    private static void initializeFieldForWin() {

        fieldForWinCheck = new int[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                fieldForWinCheck[i][j] = 0;
                System.out.print(fieldForWinCheck[i][j]);
            }
            System.out.println();
        }

    }

    // Установка размерности игрового поля
    private static void initializeField() {

        fieldSizeX = 5;
        fieldSizeY = 5;
        lineForWin = 3;

        //Инициализация игрового поля
        field = new char[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    // Отрисовка игрового поля
    private static void renderingField(char[][] field) {

        //Печатаем верхнюю часть игрового поля
        System.out.println();
        System.out.print(leftUpCorner);
        for (int i = 0; i < fieldSizeX * 2 + 4; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightUpCorner);

        //Печатаем верхнюю шапку
        System.out.print(verticalLine);
        System.out.print("  ");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if (i % 2 == 0) {
                System.out.print(" ");
            } else {
                System.out.print(i / 2 + 1);
            }
        }
        System.out.print(" ");
        System.out.println(verticalLine);

        //Печать всех строк кроме последней
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(verticalLine);
            System.out.print(" ");
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.print(" ");
            System.out.println(verticalLine);
        }

        //Печатаем нижнюю часть игрового поля
        System.out.print(leftDownCorner);
        for (int i = 0; i < fieldSizeX * 2 + 4; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightDownCorner);

    }

    private static void renderingField(int[][] field) {

        //Печатаем верхнюю часть игрового поля
        System.out.println();
        System.out.print(leftUpCorner);
        for (int i = 0; i < fieldSizeX * 2 + 4; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightUpCorner);

        //Печатаем верхнюю шапку
        System.out.print(verticalLine);
        System.out.print("  ");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if (i % 2 == 0) {
                System.out.print(" ");
            } else {
                System.out.print(i / 2 + 1);
            }
        }
        System.out.print(" ");
        System.out.println(verticalLine);

        //Печать всех строк кроме последней
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(verticalLine);
            System.out.print(" ");
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.print(" ");
            System.out.println(verticalLine);
        }

        //Печатаем нижнюю часть игрового поля
        System.out.print(leftDownCorner);
        for (int i = 0; i < fieldSizeX * 2 + 4; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightDownCorner);

    }

    // Ход первого игрока
    public static void humanOneStep() {
        System.out.print("Введи координаты \"x\" и \"y\" через пробел: ");

        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        if (x < fieldSizeX && y < fieldSizeY) {

            if (x == -1 && y == -1) {
                System.out.println("Вы сдались. Компьютер победил!!!");
                System.out.println("Нажмите \"Enter\" для выхода в главное меню");
                scanner.nextLine();
                scanner.nextLine();
                mainMenuTicTacToe();
            } else {
                field[x][y] = DOT_HUMAN_1;
                fieldForWinCheck[x][y] = humanForWinCheck;
            }

        } else {
            System.out.println("Вы ввели значение выходящие за пределы поля. Повторите ввод");
            humanOneStep();
        }

    }

    // Ход второго игрока
    public static void humanTwoStep() {
        System.out.println("Ход второго игрока (X Y через пробел): ");
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        field[x][y] = DOT_HUMAN_2;

    }

    //Ход компьютера
    public static void computerStep() {
        System.out.println("Ход компьютера: ");
        int x = random.nextInt(fieldSizeX);
        int y = random.nextInt(fieldSizeY);
        field[x][y] = DOT_COMPUTER;
        fieldForWinCheck[x][y] = computerForWinCheck;
    }

    public static void gameHumanToHuman() {
        renderingField(field);
        do {
            System.out.println("Ход игрока, ваш символ \"X\":");
            humanOneStep();
            renderingField(field);

            computerStep();
            renderingField(field);
        } while (true);
    }

    public static void gameHumanToComputer() {
        renderingField(field);
        do {
            System.out.println("Ход игрока, ваш символ \"X\":");
            humanOneStep();
            renderingField(field);
            renderingField(fieldForWinCheck);

            computerStep();

        } while (true);
    }


}
