package io.humb1t.multithreading;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Processor implements Runnable {
    int numberOfProcessor;
    ConcurrentLinkedQueue<String> queue;
    public Processor(int num, ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
        numberOfProcessor = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.add("Processor " + numberOfProcessor + ": " + i + " step of 9");
        }
    }
}
