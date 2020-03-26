package BankAndUser;

public class BalanceError extends Exception {
    public BalanceError() {
    }

    public BalanceError(String message) {
        super(message);
    }

    public BalanceError(String message, Throwable cause) {
        super(message, cause);
    }
}
