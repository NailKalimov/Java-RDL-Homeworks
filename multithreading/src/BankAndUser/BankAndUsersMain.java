package BankAndUser;

public class BankAndUsersMain {
    public static void main(String[] args) throws BalanceError, InterruptedException {

        while (true) {
            Bank bank = new Bank(1000);

            Thread thread1 = new Thread(new BankUser(bank));
            Thread thread2 = new Thread(new BankUser(bank));
            Thread thread3 = new Thread(new BankUser(bank));
            Thread thread4 = new Thread(new BankUser(bank));
            Thread thread5 = new Thread(new BankUser(bank));
            Thread thread6 = new Thread(new BankUser(bank));
            Thread thread7 = new Thread(new BankUser(bank));
            Thread thread8 = new Thread(new BankUser(bank));
            Thread thread9 = new Thread(new BankUser(bank));
            Thread thread10 = new Thread(new BankUser(bank));

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
            thread9.start();
            thread10.start();
            while (thread1.isAlive() | thread2.isAlive() | thread3.isAlive() | thread4.isAlive() | thread5.isAlive()
                    | thread6.isAlive() | thread7.isAlive() | thread8.isAlive() | thread9.isAlive()) {
                Thread.sleep(1000);
            }
        }
    }
}
