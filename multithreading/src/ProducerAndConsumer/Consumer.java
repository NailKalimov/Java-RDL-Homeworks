package ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    long timeoutInSeconds=5;
    BlockingQueue<Integer> cache;

    public Consumer(BlockingQueue<Integer> cache, long timeoutInSeconds) {
        this.cache = cache;
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public Consumer(BlockingQueue<Integer> cache) {
        this.cache = cache;
    }

    private void useData() throws InterruptedException {
        System.out.println("Consumer: " + cache.poll(timeoutInSeconds, TimeUnit.SECONDS) + " was read");
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                useData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep((int)(Math.random()*500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
