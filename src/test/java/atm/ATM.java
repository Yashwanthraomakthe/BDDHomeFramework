package atm;

public class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        account.debit(amount);
    }
}