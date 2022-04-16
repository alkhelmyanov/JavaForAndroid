package gb.Khelmyanov_HW.Lesson10.Task2;


public class Main {
    public static void main(String[] args) {
        Person person = new Person("Петров", 1111);
        Person person1 = new Person("Алексеев", 2222);
        Person person2 = new Person("Стаханов", 3333);
        //Person person3 = new Person("Петров", 4444);

        person.addPhoneNumber(1112);
        person.addPhoneNumber(1113);
        person1.addPhoneNumber(2221);
        person2.addPhoneNumber(55556);
        person2.addPhoneNumber(33222);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPerson(person.getSurname(), person.getPhoneNumber());
        phoneBook.addPerson(person1.getSurname(), person1.getPhoneNumber());
        phoneBook.addPerson(person2.getSurname(), person2.getPhoneNumber());
        //phoneBook.addPerson(person3.getSurname(), person3.getPhoneNumber());

        System.out.println(phoneBook);
        phoneBook.infoPhoneBook();

        phoneBook.get("Петров");
    }
}
