package BankAndUser;

public class Bank {
    private double moneyAmount;

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void transferMoney(int amount) throws BalanceError {
        if (hasEnoughMoney(amount)) {
            moneyAmount -= amount;
        } else {
            throw (new BalanceError("Not enough money in bank!"));
        }
    }

    public boolean hasEnoughMoney(int amount) {
        return moneyAmount >= amount;
    }
}
