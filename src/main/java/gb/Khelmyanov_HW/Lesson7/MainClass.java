package gb.Khelmyanov_HW.Lesson7;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("У вас дома появились коты: ");
        Plate plate01 = new Plate("Номер Один", 20, 20);
        Plate commonPlate = new Plate("Общая тарелка", 100, 40);

        Cat[] catovasiya = new Cat[5];
        catovasiya[0] = new Cat("Барсик");
        catovasiya[1] = new Cat("Рыжик");
        catovasiya[2] = new Cat("Бочонок");
        catovasiya[3] = new Cat("Мурзик");
        catovasiya[4] = new Cat("Бельченок");
        System.out.println();

        for (int i = 0; i < catovasiya.length; i++) {
            commonPlate.plateInfo();
            catovasiya[i].eat(commonPlate);
            System.out.println();
        } commonPlate.addFoodToPlate(70);

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
