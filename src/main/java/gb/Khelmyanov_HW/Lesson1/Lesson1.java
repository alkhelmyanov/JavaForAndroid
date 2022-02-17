package gb.Khelmyanov_HW.Lesson1;

public class Lesson1 {
    public static void main(String[] args) {

        // Задание №3
        System.out.println("Задание №3:");
        System.out.println(functionCalculation(10.5f, 2.3f, 8f, 4f));
        System.out.println();

        // Задание №4
        System.out.println("Задание №4:");
        System.out.println("Сумма чисел лежит в пределе от 10 до 20 включительно: " + limitOfNumbers(10, 11));
        System.out.println();

        // Задание №5
        System.out.println("Задание №5:");
        isPositiveOrNegative(-5);
        System.out.println();

        // Задание №6
        System.out.println("Задание №6:");
        System.out.println("Вы передали отрицательное число?: " + isNegative(-5));
        System.out.println();

        // Задание №7
        System.out.println("Задание №7:");
        Hello("Света");
        System.out.println();

        // Задание №8
        System.out.println("Задание №8:");
        leapYear(704);
    }

    // region Практическое задание №2. Инициализация переменных.
    private static void firstExercise() {
        byte a = 7;
        short b = 18200;
        int c = 23;
        long d = -3256800L;
        float e = 25.346f;
        double f = -3.15;
        char g = '☼';
        boolean h = true;
    }


    //endregion
    //region Практическое задание №3. Вычисление уравнения
    private static float functionCalculation(float a, float b, float c, float d) {
        System.out.printf("%.2f * (%.2f + (%.2f / %.2f)) = ", a, b, c, d);
        return a * (b + (c / d));
    }

    //endregion.
    //region Практическое задание №4. Предел числа
    private static boolean limitOfNumbers(int firstNumber, int secondNumber) {
        int resultOfAddition = firstNumber + secondNumber;
        if (resultOfAddition >= 10 && resultOfAddition <= 20) {
            return true;
        } else return false;
    }
    // endregion
    // region Практическое задание №5. Положительное или отрицательное число.

    private static void isPositiveOrNegative(int number) {
        if (number < 0) {
            System.out.println("Вы передали отрицательное число");
        } else {
            System.out.println("Вы передали положительное число");
        }
    }

    //endregion
    // region Практическое задание №6. Отрицательное ли число?.
    private static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    // endregion
    // region Практическое задание №7. Приветствие.
    private static void Hello(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    // endregion
    //  region Практическое задание №8. Определение високосности года.

    /**
     * этот метод проверяет является год високосным или нет
     *
     * @param year - необходимо ввести год для проверки
     */
    private static void leapYear(int year) {
        if (year % 400 == 0) {
            System.out.printf("%sг является високосным годом", year);
        } else if (year % 100 == 0) {
            System.out.printf("%sг является не високосным годом", year);
        } else if (year % 4 == 0) {
            System.out.printf("%sг является високосным годом", year);
        } else {
            System.out.printf("%sг является не високосным годом", year);
        }
    }
    //endregion
}
