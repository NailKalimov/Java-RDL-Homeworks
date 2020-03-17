package ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    long timeoutInSeconds = 5;
    BlockingQueue<Integer> cache;

    public Producer(BlockingQueue<Integer> cache, long timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
        this.cache = cache;
    }

    public Producer(BlockingQueue<Integer> cache) {
        this.cache = cache;
    }

    private void putData(int object) throws InterruptedException {
        if (cache.offer(object, timeoutInSeconds, TimeUnit.SECONDS)) {
            System.out.println("Producer: " + object + " was inserted");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                putData(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep((int) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
