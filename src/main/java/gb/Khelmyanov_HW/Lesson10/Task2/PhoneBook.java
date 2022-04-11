package gb.Khelmyanov_HW.Lesson10.Task2;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();


    public void addPerson(String surname, ArrayList<Integer> phoneNumber) {
        if (phoneBook.containsKey(surname)) {
            System.out.println("Такой абонент уже существует");
        }
        phoneBook.put(surname, phoneNumber);
    }

    public void get(String surname) {
        System.out.print("У абонента с Фамилией: " + surname + ", найдены телефонные номера: " + phoneBook.get(surname));
    }

    public void infoPhoneBook() {
        System.out.println("\nВ телефоном справочнике:");
        for (Map.Entry<String, ArrayList<Integer>> List : phoneBook.entrySet()) {
            System.out.println("Абонент: " + List.getKey() + " телефон: " + List.getValue());
        }
    }

}
