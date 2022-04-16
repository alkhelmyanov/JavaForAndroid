package gb.Khelmyanov_HW.Lesson11.Task3;

public class Main {
    public static void main(String[] args) {


        Apple apple = new Apple(15);
        Orange orange = new Orange(20);
        Orange orange1 = new Orange(25);

        Box<Apple> AppleBox = new Box<>("коробку для Яблок");
        //Box<Orange> OrangeBox = new Box<>("коробку для Апельсинов", orange);

        AppleBox.addFruit(apple);
        AppleBox.addFruit(apple);
        //OrangeBox.addFruit(orange);
      // OrangeBox.addFruit(orange1);

        AppleBox.getWeight();
       // OrangeBox.getWeight();


    }
}
