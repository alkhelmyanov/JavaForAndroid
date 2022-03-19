package gb.Khelmyanov_HW.Lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    static String nameOfGame = "Крестики Нолики / tic-tac-toe   ";

    static final char DOT_HUMAN_1 = 'X';
    static final char DOT_HUMAN_2 = '0';
    static final char DOT_COMPUTER = '0';
    static final char DOT_EMPTY = '▪';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int fieldSizeX = 5;
    static int fieldSizeY = 5;
    static char[][] field;
    static int lineForWin = 3;

    //Эти переменные необходимы для проверки на победу и для имитации ИИ компьютера.
    //static int[][] fieldForWinCheck;
    //static int humanForWinCheck = 7;
    //static int computerForWinCheck = 3;

    static int compWinX;
    static int compWinY;
    static int computerAlert = 0;

    static char leftUpCorner = '\u2554'; // символ ╔
    static char leftDownCorner = '\u255A'; // символ ╚
    static char rightUpCorner = '\u2557'; // символ ╗
    static char rightDownCorner = '\u255D'; // символ ╝
    static char horizontalLine = '\u2550'; // символ ═
    static char verticalLine = '\u2551'; // символ ║

    //static String printLine;
    static String winShout = "Поздравляем Вы победили!!!!!!";


    public static void main(String[] args) {
        //Создать вначале игры меню с Настройками, где будет выбор играть с человеком или компьютером, плюс размер поля, плюс кол-во знаков в ряд для победы.
        initializeField();
        mainMenuTicTacToe();
    }


    // Отрисовка главного меню
    private static void mainMenuTicTacToe() {

        // Инициализация поля

        boolean f = true;
        while (f) {
            //Печатаем верхнюю часть меню с названием игры
            System.out.println();
            System.out.print(leftUpCorner);
            for (int i = 0; i < nameOfGame.length() + 2; i++) {
                System.out.print(horizontalLine);
            }
            System.out.println(rightUpCorner);

            printLineWithQuotes(nameOfGame);
            printLineWithQuotes("--------------------------------");
            printLineWithQuotes("  1 - Начать игру c компьютером ");
            printLineWithQuotes("  2 - Начать игру cо 2м игроком ");
            printLineWithQuotes("  3 - Настройки                 ");
            printLineWithQuotes("  0 - Выход из игры             ");
            printLineWithQuotes("--------------------------------");
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
                case 2 -> gameHumanToHuman();
                case 3 -> renderingMenuOptions();
                case 0 -> {
                    f = false;
                    System.out.print("В следующий раз Удача будет на моей стороне :)!!!");
                    scanner.close();
                }
                default -> System.out.println("Такого варианта нет :(");
            }
        }
    }

    // Отрисовка меню Настройки
    private static void renderingMenuOptions() {
        System.out.println();
        System.out.print(leftUpCorner);
        for (int i = 0; i < nameOfGame.length() + 3; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightUpCorner);
        printLineWithQuotes("---------------------------------");
        printLineWithQuotes(" 1 - Размер игрового поля   " + fieldSizeX + " x " + fieldSizeY);
        printLineWithQuotes(" 2 - Длинна победной линии    " + lineForWin + "  ");
        printLineWithQuotes(" 0 - Выйти из настройки          ");
        printLineWithQuotes("---------------------------------");

        //Печатаем нижнюю часть игрового поля
        System.out.print(leftDownCorner);
        for (int i = 0; i < nameOfGame.length() + 3; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(rightDownCorner);

        runMenuOptions();
    }

    private static void runMenuOptions() {
        System.out.print("Выберете опцию: ");
        int menuOptionsChoice = scanner.nextInt();
        switch (menuOptionsChoice) {
            case 1:
                System.out.println("Введите размер игрового поля (через пробел): ");
                fieldSizeX = scanner.nextInt();
                fieldSizeY = scanner.nextInt();
                if (fieldSizeX > 9 || fieldSizeY > 9) { // больше идет искривление поля
                    System.out.println("Не буду играть на кривом поле. Пусть будет 9 на 9");
                    fieldSizeX = 9;
                    fieldSizeY = 9;
                }
                break;
            case 2:
                System.out.print("Введите длину победной линии: ");
                lineForWin = scanner.nextInt();
                if (lineForWin > fieldSizeX) {
                    System.out.println("Не хватит игрового поля!!! Максимальная длинна " + fieldSizeX);
                    lineForWin = fieldSizeX;
                }
                if (lineForWin > fieldSizeY)
                    System.out.println("Не хватит игрового поля!!! Максимальная длинна " + fieldSizeY);
                lineForWin = fieldSizeY;
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

    /*//Иницализация поля для вычисления победы
    private static void initializeFieldForWin() {

        fieldForWinCheck = new int[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                fieldForWinCheck[i][j] = 0;
                System.out.print(fieldForWinCheck[i][j]);
            }
            System.out.println();
        }

    }*/

    // Установка размерности игрового поля
    private static void initializeField() {

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


    // Ход первого игрока
    public static void humanOneStep() {
        System.out.println("Ход игрока (" + DOT_HUMAN_1 + ")");
        System.out.print("Введи координаты \"x\" и \"y\" через пробел: ");

        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        if (x == -2 && y == -2) {
            System.out.println("Вы сдались. Оппонент победил!!!"); // возможность выйти раньше, если надоело или увлеклись с размерами поля :)
            System.out.println("Нажмите \"Enter\" для выхода в главное меню");
            scanner.nextLine();
            scanner.nextLine();
            mainMenuTicTacToe();
        }
        if (rangeOfGame(x, y) && cellIsEmpty(x, y)) {
            field[x][y] = DOT_HUMAN_1;
        } else {
            System.out.println("\nВы ввели значение выходящие за пределы поля,\nили попытались захватить чужую ячейку. Попробуйте еще разок\n");
            //}
            humanOneStep();
        }

    }

    // Ход второго игрока
    public static void humanTwoStep() {

        System.out.println("Ход второго игрока (" + DOT_HUMAN_2 + ")");
        System.out.print("Введи координаты \"x\" и \"y\" через пробел: ");

        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        if (x == -2 && y == -2) {
            System.out.println("Вы сдались. Оппонент победил!!!"); // возможность выйти раньше, если надоело или увлеклись с размерами поля :)
            System.out.println("Нажмите \"Enter\" для выхода в главное меню");
            scanner.nextLine();
            scanner.nextLine();
            mainMenuTicTacToe();
        }
        if (rangeOfGame(x, y) && cellIsEmpty(x, y)) {
            field[x][y] = DOT_HUMAN_2;
        } else {
            System.out.println("\nВы ввели значение выходящие за пределы поля,\nили попытались захватить чужую ячейку. Попробуйте еще разок\n");
            //}
            humanTwoStep();
        }
    }

    //Ход компьютера
    public static void computerStep() {
        int x;
        int y;
        System.out.println("Компьютер сходил \"O\"\n....... ");
        if (computerAlert == 1){
            x = compWinX;
            y = compWinY;
            System.out.println("computerAlert = " + computerAlert);
            computerAlert = 0;
        } else {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        // System.out.println("Компьютер ввел " + x + "  " + y);
        //System.out.println("Ячейки заняты " + cellIsEmpty(x, y));
        System.out.println("computerAlert = " + computerAlert);
        if (rangeOfGame(x,y) && cellIsEmpty(x, y)) {
            field[x][y] = DOT_COMPUTER;
            System.out.println("\nКомпьютер сходил " + x + " " + y);
        } else {
            System.out.println("Компьютер ходит еще раз");
            computerStep();
        }
    }

    //Игра Человек против Человека
    public static void gameHumanToHuman() {
        initializeField();
        renderingField(field);
        do {

            humanOneStep();
            checkWinByLine(DOT_HUMAN_1);
            renderingField(field);

            humanTwoStep();
            checkWinByLine(DOT_HUMAN_2);
            renderingField(field);


        } while (!checkWinByLine(DOT_HUMAN_1) && !checkWinByLine(DOT_HUMAN_2));

        System.out.println("Игра завершена!!!");
        System.out.println("Нажмите \"Enter\" для выхода в главное меню");
        scanner.nextLine();
        scanner.nextLine();
        mainMenuTicTacToe();

    }

    // Игра человек против компьютера
    public static void gameHumanToComputer() {
        initializeField();
        renderingField(field);
        do {
            humanOneStep();
            renderingField(field);
            checkWinByLine(DOT_HUMAN_1);

            computerStep();
            checkWinByLine(DOT_COMPUTER);
            renderingField(field);
            //System.out.println(checkWinByLine(DOT_COMPUTER));
        } while (!checkWinByLine(DOT_HUMAN_1) && !checkWinByLine(DOT_COMPUTER));

        System.out.println("Игра завершена!!!");
        System.out.println("Нажмите \"Enter\" для выхода в главное меню");
        scanner.nextLine();
        scanner.nextLine();
        mainMenuTicTacToe();
    }

    public static boolean checkWinByLine(char charOfPlayer) {
        int winCheckCount = 0;
        System.out.println("Горизонталь = " + winCheckCount);
        // проверка горизонтали на победу
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == charOfPlayer) {
                    winCheckCount++;
                    // Если две фишки стоят подряд, то компьютер делает вывод, что следующую надо ставить ему
                    if (winCheckCount == 2){
                        computerAlert = 1;
                        compWinX = i;
                        compWinY = j + 1;
                        System.out.println(compWinX + " " + compWinY);
                    }

                    //System.out.println("счетчик равен: " + winCheckCount);
                    if (winCheckCount == lineForWin) {
                        System.out.println(winShout);
                        return true;
                    }
                } else {
                    winCheckCount = 0;
                }
            }
        }

        // проверка вертикали на победу
        winCheckCount = 0;
        System.out.println("вертикаль = " + winCheckCount);
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[j][i] == charOfPlayer) {
                    winCheckCount++;
                    // Если две фишки стоят подряд, то компьютер делает вывод, что следующую надо ставить ему
                    if (winCheckCount == 2){
                        computerAlert = 1;
                        compWinX = i + 1;
                        compWinY = j;
                        System.out.println(compWinX + " " + compWinY);
                    }
                    //System.out.println("счетчик равен: " + winCheckCount);
                    if (winCheckCount == lineForWin) {
                        System.out.println(winShout);
                        return true;
                    }
                } else {
                    winCheckCount = 0;
                }
            }
        }
        // проверка нисходящей диагонали на победу
        winCheckCount = 0;
        System.out.println("нисходящей диагонали = " + winCheckCount);
        int kCountEnd = fieldSizeX - 1;
        int jCount = 0;
        int i = fieldSizeX - 1;
        int j = 0;

        for (int s = fieldSizeX; s > 0; s--) {
            for (int k = fieldSizeX; k > kCountEnd; k--) {
                if (field[j][i] == charOfPlayer) {
                    winCheckCount++;
                    // Если две фишки стоят подряд, то компьютер делает вывод, что следующую надо ставить ему
                    if (winCheckCount == 2){
                        computerAlert = 1;
                        compWinX = i - 1;
                        compWinY = j - 1;
                        System.out.println(compWinX + " " + compWinY);
                    }
                    //System.out.println("счетчик равен: " + winCheckCount);
                    if (winCheckCount == lineForWin) {
                        System.out.println(winShout);
                        return true;
                    }
                } else {
                    winCheckCount = 0;
                }
                i--;
                j--;
            }
            j = jCount + 1;
            jCount++;
            i = fieldSizeX - 1;
            kCountEnd--;
        }


        int kCountStart = fieldSizeX - 1;
        jCount = 1;
        i = 0;
        j = 1;

        for (int s = 0; s < fieldSizeX - 2; s++) {
            for (int k = kCountStart; k > 0; k--) {
                if (field[j][i] == charOfPlayer) {
                    winCheckCount++;
                    // Если две фишки стоят подряд, то компьютер делает вывод, что следующую надо ставить ему
                    if (winCheckCount == 2){
                        computerAlert = 1;
                        compWinX = i - 1;
                        compWinY = j - 1;
                        System.out.println(compWinX + " " + compWinY);
                    }
                    //System.out.println("счетчик равен: " + winCheckCount);
                    if (winCheckCount == lineForWin) {
                        System.out.println(winShout);
                        return true;
                    }
                } else {
                    winCheckCount = 0;
                }
                i++;
                j++;
            }
            i = 0;
            j = jCount + 1;
            jCount++;
            kCountStart--;
        }

        // проверка восходящей диагонали на победу
        winCheckCount = 0;
        kCountEnd = 1;
        int iCount = 0;
        i = 0;
        j = 0;
        System.out.println("восходящая диагонали = " + winCheckCount);
        for (int s = 0; s < fieldSizeX; s++) {

            for (int k = 0; k < kCountEnd; k++) {
                if (field[j][i] == charOfPlayer) {
                    winCheckCount++;
                    // Если две фишки стоят подряд, то компьютер делает вывод что следующую надо ставить ему
                    if (winCheckCount == 2){
                        computerAlert = 1;
                        compWinX = i + 1;
                        compWinY = j + 1;
                        System.out.println(compWinX + " " + compWinY);
                    }
                    // System.out.println("счетчик равен: " + winCheckCount);
                    if (winCheckCount == lineForWin) {
                        System.out.println(winShout);
                        return true;
                    }
                } else {
                    winCheckCount = 0;
                }
                i--;
                j++;
            }
            i = iCount + 1;
            iCount++;
            j = 0;
            kCountEnd++;
        }

        kCountEnd = 1;
        jCount = 1;
        i = fieldSizeX - 1;
        j = 1;

        for (int s = 0; s < fieldSizeX - 2; s++) {
            for (int k = fieldSizeX; k > kCountEnd; k--) {
                if (field[j][i] == charOfPlayer) {
                    winCheckCount++;
                    // Если две фишки стоят подряд, то компьютер делает вывод что следующую надо ставить ему
                    if (winCheckCount == 2){
                        computerAlert = 1;
                        compWinX = i + 1;
                        compWinY = j + 1;
                        System.out.println(compWinX + " " + compWinY);
                    }
                    //System.out.println("счетчик равен: " + winCheckCount);
                    if (winCheckCount == lineForWin) {
                        System.out.println(winShout);
                        return true;
                    }
                } else {
                    winCheckCount = 0;
                }
                i--;
                j++;
            }
            i = fieldSizeX - 1;
            j = jCount + 1;
            jCount++;
            kCountEnd++;
        }
        return false;
    }

    // Проверка не занимает ли новая фишка заполненную клетку.
    // Если занимает, то возвращает false, если свободна, то true.

    public static boolean cellIsEmpty(int x, int y) {
        return field[x][y] != DOT_HUMAN_1 && field[x][y] != DOT_HUMAN_2 && field[x][y] != DOT_COMPUTER;
    }

    // Проверка не выходит ли ход за диапазон ячеек.
    // Если выходит за пределы то, возвращает false, если не выходит, то true.

    public static boolean rangeOfGame(int x, int y) {
        return x >= 0 && y >= 0 && x <= fieldSizeX && y <= fieldSizeY;
    }

    /*private static void renderingField(int[][] field) {

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

    }*/

     /* public static void checkWin(int lineForWin) {

        System.out.println(Arrays.deepToString(fieldForWinCheck));
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (fieldForWinCheck[i][j] == humanForWinCheck) {
                    chekLineForPCorHumanfill(i, j, humanForWinCheck);

                    System.out.println(i + " " + j + " = " + humanForWinCheck);
                    renderingField(fieldForWinCheck);
                }
                if (fieldForWinCheck[i][j] == computerForWinCheck) {
                    chekLineForPCorHumanfill(i, j, computerForWinCheck);

                    System.out.println(i + " " + j + " = " + computerForWinCheck);
                    renderingField(fieldForWinCheck);
                }
            }
        }
    }*/




/*    public static void checkWin2() {
        int winCount = 0;
        do {
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    if (fieldForWinCheck[i][j] == 7) {
                        winCount++;
                    } else {
                        winCount = 0;
                    }
                }
            }
        } while (winCount != 3);

    }*/

    /*   // Этот метод заполняет соседние вокруг хода игрока ячейки определенным значением
    public static void chekLineForPCorHumanfill(int i, int j, int winCheckNumber) {

        int first = 1; // значение, которое выставляется вокруг первого числа
        int second = 2;// значение, которое выставляется вокруг второго числа
        int numberForCalculatedWin; // Значение либо first (если первый игрок сходил) Либо second (если второй сходил)
        if (winCheckNumber == humanForWinCheck) {
            numberForCalculatedWin = first;
        } else {
            numberForCalculatedWin = second;
        } // условие выполняется если индекс не выходит за пределы массива, и значение ячейки не является значением хода одного из игроков
        if (isCellValid(i - 1, j - 1) && fieldForWinCheck[i - 1][j - 1] != humanForWinCheck && fieldForWinCheck[i - 1][j - 1] != computerForWinCheck) {
            fieldForWinCheck[i - 1][j - 1] = numberForCalculatedWin;
        }
        if (isCellValid(i - 1, j) && fieldForWinCheck[i - 1][j] != humanForWinCheck && fieldForWinCheck[i - 1][j] != computerForWinCheck) {
            fieldForWinCheck[i - 1][j] = numberForCalculatedWin;
        }
        if (isCellValid(i - 1, j + 1) && fieldForWinCheck[i - 1][j + 1] != humanForWinCheck && fieldForWinCheck[i - 1][j + 1] != computerForWinCheck) {
            fieldForWinCheck[i - 1][j + 1] = numberForCalculatedWin;
        }
        if (isCellValid(i, j - 1) && fieldForWinCheck[i][j - 1] != humanForWinCheck && fieldForWinCheck[i][j - 1] != computerForWinCheck) {
            fieldForWinCheck[i][j - 1] = numberForCalculatedWin;
        }
        if (isCellValid(i, j + 1) && fieldForWinCheck[i][j + 1] != humanForWinCheck && fieldForWinCheck[i][j + 1] != computerForWinCheck) {
            fieldForWinCheck[i][j + 1] = numberForCalculatedWin;
        }
        if (isCellValid(i + 1, j - 1) && fieldForWinCheck[i + 1][j - 1] != humanForWinCheck && fieldForWinCheck[i + 1][j - 1] != computerForWinCheck) {
            fieldForWinCheck[i + 1][j - 1] = numberForCalculatedWin;
        }
        if (isCellValid(i + 1, j) && fieldForWinCheck[i + 1][j] != humanForWinCheck && fieldForWinCheck[i + 1][j] != computerForWinCheck) {
            fieldForWinCheck[i + 1][j] = numberForCalculatedWin;
        }
        if (isCellValid(i + 1, j + 1) && fieldForWinCheck[i + 1][j + 1] != humanForWinCheck && fieldForWinCheck[i + 1][j + 1] != computerForWinCheck) {
            fieldForWinCheck[i + 1][j + 1] = numberForCalculatedWin;
        }
    }*/
}
