package AccountConstruction;
import BankComponents.Client;
public class CurrentAccount extends Account {
    private CurrentAccount(Client client) {
        super(client);
    }

    @Override
    public void deposit(double value) {
        if (value > 0) {
            this.client.deposit(value);
        } else {
            throw new RuntimeException("Invalid value");
        }
    }

    @Override
    public void withdraw(double value) {
        if (this.client.getBalance() >= value) {
            this.client.withdraw(value);
        } else {
            throw new RuntimeException("Insufficient balance.");
        }
    }

    @Override
    public void transfer(double value, AccountsInterface destination) {
        if (this.client.getBalance() >= value) {
            this.withdraw(value);
            destination.deposit(value);
        } else {
            throw new RuntimeException("Insufficient balance for transfer");
        }
    }

    @Override
    public void printStatement() {
        System.out.println("=== Account Balance ===");
        System.out.println(client);
    }

    public static class CurrentAccountBuilder {
        private Client client;

        public CurrentAccountBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public CurrentAccount build() {
            return new CurrentAccount(client);
        }
    }
}
