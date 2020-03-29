package DiningPhilosophers;

public class Main {

    public static void main(String[] args) {
        int numberOfPhilosopher = 5;
        Fork[] forks = new Fork[numberOfPhilosopher];
        Philosopher[] philosophers = new Philosopher[numberOfPhilosopher];

        for (int i = 0; i < numberOfPhilosopher; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < numberOfPhilosopher; i++) {
            //С помощью этого условия я задаю, чтобы один из философов в превую очередь пытался взять вилку с правой
            // стороны, а потом с левой. При таком раскладе deadlock не произойдет.
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
