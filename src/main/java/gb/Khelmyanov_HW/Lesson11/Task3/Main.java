package gb.Khelmyanov_HW.Lesson11.Task3;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Создание объектов фруктов ***");
        Apple apple = new Apple(10);
        Orange orange = new Orange(10);
        Orange orange1 = new Orange(20);

        System.out.println("\n*** Создание объектов коробок ***");
        Box<Apple> appleBox = new Box<>("коробку для Яблок");
        Box<Apple> appleBox1 = new Box<>("коробку для Яблок");

        Box<Orange> orangeBox = new Box<>("коробку для Апельсинов", orange);
        Box<Orange> orangeBox1 = new Box<>("коробку для Апельсинов", orange1);

        System.out.println("\n *** Добавление фруктов в коробки ***");
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox1.addFruit(apple);
        //appleBox1.addFruit(apple);

        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange1);


        System.out.println("\n*** Расчет веса коробоки ***");
        System.out.println("вес appleBox = " + appleBox.getWeight());
        System.out.println("вес orangeBox = " + appleBox1.getWeight());

        System.out.println("\n*** Сравнение коробок ***");
        System.out.println(appleBox.compare(appleBox1));

        System.out.println("*** Перемещение из одной коробки в другую ***");
        System.out.println("*** До перемещения:");
        System.out.println("orangeBox = " + orangeBox.arrayList);
        System.out.println("appleBox = " + appleBox.arrayList);
        System.out.println("appleBox1 = " + appleBox1.arrayList);

            appleBox.transferFruit(appleBox1); // из какой коробки, в параметрах в какую коробку переместить фрукты
            //appleBox.transferFruit(orangeBox); // из какой коробки, в параметрах в какую

        System.out.println("*** После перемещения:");
        System.out.println("orangeBox = " + orangeBox.arrayList);
        System.out.println("appleBox = " + appleBox.arrayList);
        System.out.println("appleBox1 = " + appleBox1.arrayList);

        System.out.println("\n*** Расчет веса коробоки ***");
        System.out.println("вес appleBox = " + appleBox.getWeight());
        System.out.println("вес appleBox1 = " + appleBox1.getWeight());

        System.out.println("***");
        System.out.println("\n*** Сравнение коробок ***");
        System.out.println(appleBox.compare(appleBox1));

        System.out.println("\n *** Добавление фруктов в коробку appleBox ***");
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);

        System.out.println("\n*** Расчет веса коробоки ***");
        System.out.println("вес appleBox = " + appleBox.getWeight());
        System.out.println("вес appleBox1 = " + appleBox1.getWeight());

        System.out.println("***");
        System.out.println("\n*** Сравнение коробок ***");
        System.out.println(appleBox.compare(appleBox1));
    }
}
