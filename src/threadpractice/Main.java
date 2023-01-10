package threadpractice;

public class Main {
    public static void main(String[] args) {
        Runnable threadTask = new ThreadTask();
        Thread thread1 = new Thread(threadTask);
        Thread thread2 = new Thread(threadTask);

        thread1.setName("A");
        thread2.setName("B");

        thread1.start();
        thread2.start();
    }
}