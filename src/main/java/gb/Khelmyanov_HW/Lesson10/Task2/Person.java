package gb.Khelmyanov_HW.Lesson10.Task2;

import java.util.ArrayList;

public class Person  {

    ArrayList<Integer> arrayListPersonal = new ArrayList<>();
    private String surname;

    public String getSurname() {

        return surname;
    }

    public ArrayList<Integer> getPhoneNumber() {
        return arrayListPersonal;
    }


    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", phoneNumber=" + arrayListPersonal +
                '}';
    }


    public Person(String surname, Integer phoneNumber) {
        this.surname = surname;

        arrayListPersonal.add(phoneNumber);


    }

    public ArrayList<Integer> addPhoneNumber(Integer phoneNumber) {
        arrayListPersonal.add(phoneNumber);
        return arrayListPersonal;
    }


}
