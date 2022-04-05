package gb.Khelmyanov_HW.Lesson9;

public class MyArrayDataException extends Exception {
    private final int x;
    private final int y;
    //public MyArrayDataException(String message, int i, int j, String temp) {
    //    System.out.println(message + ". В ячейке с индексами : " + i + " и " + j + " находится значение : " + temp );
    //    private final int x;
    //    private final int y;



    public MyArrayDataException(String message, int x, int y, String temp) {
        super(message);
        this.x = x;
        this.y = y;
    }


    int getX() {
        return x;
    }

    int getY() {
        return y;
    }


    // MyArrayDataException.i = i;
    // MyArrayDataException.j = j;
    //System.out.println("Строковое значение не может быть преобразовано в целочисленное, так как не является числом.");

}


