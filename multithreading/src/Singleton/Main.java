package Singleton;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SunService());
        Thread thread2 = new Thread(new SunService());
        Thread thread3 = new Thread(new SunService());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
