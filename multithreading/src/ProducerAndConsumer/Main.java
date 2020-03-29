package ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> cache = new ArrayBlockingQueue<>(5, true);
        Thread producer = new Thread(new Producer(cache, 10));
        Thread consumer = new Thread(new Consumer(cache, 10));

        producer.start();
        consumer.start();
    }
}
