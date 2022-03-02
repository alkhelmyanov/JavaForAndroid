package gb.Khelmyanov_HW.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    static final char DOT_HUMAN_1 = 'X';
    static final char DOT_HUMAN_2 = '0';
    static final char DOT_COMPUTER = '0';
    static final char DOT_EMPTY = '▪';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int fieldSizeX;
    static int fieldSizeY;
    static char[][] field;

    public static void main(String[] args) {
        //Создать вначале игры меню с Настройками, где будет выбор играть с человеком или компьютером, плюс размер поля, плюс кол-во знаков в ряд для победы.

        initializeField();
        renderingField();


    }

    // Установка размерности игрового поля

    private static void initializeField() {

        fieldSizeX = 3;
        fieldSizeY = 3;

        //Инициализация игрового поля
        field = new char[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    // Отрисовка игрового поля
    private static void renderingField() {

        char leftUpCorner = '\u2554'; // символ ╔
        char leftDownCorner = '\u255A'; // символ ╚
        char rightUpCorner = '\u2557'; // символ ╗
        char rightDownCorner = '\u255D'; // символ ╝
        char horizontalLine = '\u2550'; // символ ═
        char verticalLine = '\u2551'; // символ ║

        //Печатаем верхнюю часть игрового поля
        System.out.printf("Игра %d на %d", fieldSizeX,fieldSizeY);
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
          if (i % 2 == 0){
              System.out.print(" ");
          } else {
              System.out.print(i/2 + 1);
          }

        }
        System.out.print(" ");
        System.out.println(verticalLine);

        //Печать всех строк кроме последней

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(verticalLine);
            System.out.print(" ");
            System.out.print( i + 1 + "|");

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




}
