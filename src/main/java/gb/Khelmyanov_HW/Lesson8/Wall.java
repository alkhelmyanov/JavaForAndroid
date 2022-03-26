package gb.Khelmyanov_HW.Lesson8;

public class Wall implements Obstruction {

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Wall.height = height;
    }

    protected static int height;

}
