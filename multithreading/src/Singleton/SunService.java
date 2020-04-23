package Singleton;

public class SunService implements Runnable {

    @Override
    public void run() {
        Sun sun1 = Sun.getSun();
        Sun sun2 = Sun.getSun();
        if (sun1 == sun2) {
            System.out.println("Поток " + Thread.currentThread().getName() + " не смог создать два солнца.");
        } else {
            System.out.println("Поток " + Thread.currentThread().getName() + " смог создать два солнца.");
        }
    }
}
