package io.humb1t.multithreading;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueImplementation {
    static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Processor(1, queue));
        Thread thread2 = new Thread(new Processor(2, queue));
        Thread thread3 = new Thread(new Processor(3, queue));

        thread1.start();
        thread2.start();
        thread3.start();

        while (thread1.isAlive() | thread2.isAlive() | thread3.isAlive()){
            Thread.sleep(1000);
        }

        queue.forEach(System.out::println);
        System.out.println("Queue length=" + queue.size());
    }
}
