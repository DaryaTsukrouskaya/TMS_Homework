package paymentsystem.exceptions;

public class BankAccountNotDeletedException extends Exception {
    public BankAccountNotDeletedException(String message) {
        super(message);
    }
}
