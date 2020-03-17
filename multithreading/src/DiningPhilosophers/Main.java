package DiningPhilosophers;

public class Main {
    private static int numberOfPhilosopher = 5;

    public static void main(String[] args) {
        Fork[] forks = new Fork[numberOfPhilosopher];
        Philosopher[] philosophers = new Philosopher[numberOfPhilosopher];
        for (int i = 0; i < numberOfPhilosopher; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < numberOfPhilosopher; i++) {
            if (i != 4) {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numberOfPhilosopher]);
            } else {
                philosophers[i] = new Philosopher(i, forks[(i + 1) % numberOfPhilosopher], forks[i]);

            }
            Thread philosopher = new Thread(philosophers[i]);
            philosopher.start();
        }

    }
}