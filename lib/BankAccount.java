package lib;

public class BankAccount {
    private long balance = 0;

    public synchronized void deposit(long amount) {
        balance += amount;
    }

    public synchronized void withDraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public long getBalance() {
        if (balance >= 0) {
            return this.balance;
        }
        else {
            System.out.println("Don't have enough");
            return 0;
        }
    }
}
