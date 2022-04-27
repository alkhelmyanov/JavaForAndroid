package gb.Khelmyanov_HW.Lesson12;

public class Task1 {

    final static int SIZE = 10000000;
    final static int HALF = SIZE / 2;

    public static void main(String[] args) {

        // Создание массива и заполнение его единицами.
        System.out.println("Заполнение массива единицами...");
        float[] arr = new float[SIZE];
        for (int i = 0; i < Task1.SIZE; i++) {
            arr[i] = 1;
        }
        System.out.println("Массив заполнен единицами.");

        TaskForRun taskForRun = new TaskForRun();

        // Запуск первого метода
        taskForRun.method1(arr);
        // Запуск второго метода
        taskForRun.method2(arr);

    }


}

class TaskForRun {

    public void method1(float[] arr) {
        System.out.println("\nЗапуск метода номер 1");
        // Пересчет массива с помощью заданной формулы.
        System.out.println("Начало потока: " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();

        System.out.println("Пересчет массива с помощью заданной формулы");
        for (int i = 0; i < Task1.SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        System.out.println("Завершение потока: " + Thread.currentThread().getName());
        long endTime = System.currentTimeMillis();
        long calcTime = endTime - startTime;
        System.out.printf("На выполнение процесса с пересчетом целого массива потрачено %d мс.%n", calcTime);
        //System.out.println(Arrays.toString(arr));

    }

    public void method2(float[] arr) {

        // Пересчет массива с помощью заданной формулы. Вариант с разбиением на amountThread потоков.
        System.out.println("\nЗапуск метода номер 2");
        // System.out.println(Arrays.toString(arr));


        System.out.println("Начало потока: " + Thread.currentThread().getName() + " с массивом длинной: " + arr.length);
        long startTime = System.currentTimeMillis();

        float[] a1 = new float[Task1.HALF];
        float[] a2 = new float[Task1.HALF];

        System.out.println("Разбиваем массив на 2 части");
        System.arraycopy(arr, 0, a1, 0, Task1.HALF);
        System.arraycopy(arr, Task1.HALF, a2, 0, Task1.HALF);

        Thread thread1 = new MyThread("Поток массива a1", a1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new MyThread("Поток массива a2", a2);
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, Task1.HALF);
        System.arraycopy(a2, 0, arr, Task1.HALF, Task1.HALF);

        System.out.println("\nдлинна массива после завершения " + arr.length);
        System.out.println("Завершение потока: " + Thread.currentThread().getName());
        long endTime = System.currentTimeMillis();
        long calcTime = endTime - startTime;
        System.out.printf("На выполнение процесса с разбиением на 2 массива потрачено %d мс.%n", calcTime);


    }
}

class MyThread extends Thread {

    private float[] arr;

    public MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
    }

    @Override
    public void run() {

        System.out.println("\nСтарт дополнительного потока: " + Thread.currentThread().getName() + " длинной " + arr.length);
        System.out.println("Пересчет массива с помощью заданной формулы");
        for (int i = 0; i < Task1.HALF; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        System.out.println("Завершение дополнительного потока");
    }
}
