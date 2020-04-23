package DiningPhilosophers;

public class Philosopher implements Runnable {
    private final Fork leftFork;
    private final Fork rightFork;
    private int id;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    void think() {
        System.out.println(nameOfPhilosopher() + "thinking");
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void eat() {
        synchronized (leftFork) {
            System.out.println(nameOfPhilosopher() + "takes the fork#" + leftFork.getNumberOfFork());
            synchronized (rightFork) {
                System.out.println(nameOfPhilosopher() + "takes the fork#" + rightFork.getNumberOfFork());
                System.out.println(nameOfPhilosopher() + "eats");
                try {
                    Thread.sleep((int) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(nameOfPhilosopher() + "puts the fork#" + rightFork.getNumberOfFork() + " to the table");
        }
        System.out.println(nameOfPhilosopher() + "puts the fork#" + leftFork.getNumberOfFork() + " to the table");
    }

    private String nameOfPhilosopher() {
        return "DiningPhilosophers.Philosopher#" + id + " ";
    }

    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }
}
