package gb.Khelmyanov_HW.Lesson5;

import java.util.Arrays;

public class Employee {
    String fullName;
    String position;
    String email;
    int phoneNumber;
    int salary;
    int age;

    //region Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //endregion

    private void info() {
        System.out.printf("ФИО: %s, должность: %s, email: %s, телефон: %d, зарплата: %d, возраст: %d\n", fullName, position, email, phoneNumber, salary, age);
    }

    private Employee(String fullName, String position, String email, int phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {
        int count = 0;

        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Ivanov Petr Sergeevich", "PartyChief", "IvanovPS@mail.ru", 896311111, 100000, 55);
        employeeArray[1] = new Employee("Sergeev Stanislav Petrovich", "navigator", "sergeevSP@mail.ru", 896322222, 50000, 40);
        employeeArray[2] = new Employee("Sinicin Alexander Semenovich", "observer", "sinicinAS@mail.ru", 896333333, 49000, 39);
        employeeArray[3] = new Employee("Patrikeeva Svetlana Yurievna", "orderly", "patrikeevaSY@mail.ru", 896444444, 20000, 22);
        employeeArray[4] = new Employee("Vaganov Alexey Stanislavovich", "cook", "vaganovAS@mail.ru", 896555555, 25000, 30);

        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() >= 40) {
                employeeArray[i].info();
            }
        }
    }
}
