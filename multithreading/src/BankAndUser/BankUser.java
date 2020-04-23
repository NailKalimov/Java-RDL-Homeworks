package BankAndUser;

public class BankUser implements Runnable {

    final Bank bank;
    int sizeOfTransaction = 1;

    public BankUser(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (bank) {
                try {
                    bank.transferMoney(sizeOfTransaction);
                } catch (BalanceError balanceError) {
                    System.out.println("In bank: " + bank.getMoneyAmount());
                    balanceError.printStackTrace();
                    System.exit(-2);
                }
                System.out.println(bank.getMoneyAmount());
                try {
                    Thread.sleep((int) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}