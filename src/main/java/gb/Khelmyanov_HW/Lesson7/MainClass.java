package gb.Khelmyanov_HW.Lesson7;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("У вас дома появились коты: ");
        Cat cat01 = new Cat("Барсик", 30);
        Cat cat02 = new Cat("Рыжик", 5);
        Cat cat03 = new Cat("Бочонок", 14);
        System.out.println();

        Plate plate01 = new Plate("Номер Один", 20, 20);
        Plate commonPlate = new Plate("Общая тарелка", 100, 40);

        Cat [] catovasiya = new Cat[6];


        /*plate01.plateInfo();
        cat01.eat(plate01);
        System.out.println();
        plate01.plateInfo();
        cat02.eat(plate01);
        System.out.println();
        plate01.plateInfo();
        cat03.eat(plate01);
        System.out.println();
        plate01.addFoodToPlate(40);
        cat02.eat(plate01);
        System.out.println();
        cat01.eat(plate01);*/

    }
}
