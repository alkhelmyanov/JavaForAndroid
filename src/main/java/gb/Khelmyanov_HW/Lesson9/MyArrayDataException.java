package gb.Khelmyanov_HW.Lesson9;

public class MyArrayDataException extends Exception {
    private final int x;
    private final int y;

    public MyArrayDataException(String message, int x, int y, String IncorrectValue) {
        super(message);
        this.x = x;
        this.y = y;


        System.out.println(message + ". В ячейке с индексами : " + x + " и " + y + " находится значение : " + IncorrectValue);

    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

}


