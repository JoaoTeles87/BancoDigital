package AccountConstruction;

public interface AccountsInterface {
    void deposit(double value);
    void withdraw(double value);
    void transfer(double value, AccountsInterface destination);

    void printStatement();
}
