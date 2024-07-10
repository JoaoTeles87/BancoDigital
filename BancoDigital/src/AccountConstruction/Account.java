package AccountConstruction;
import java.lang.Math;
import BankComponents.Client;

public abstract class Account implements AccountsInterface {
    private static int sequence = (int) Math.random();

    protected Client client;
    protected int number;

    protected Account(Client client) {
        this.number = sequence;
        this.client = client;
    }

    public static class AccountBuilder {

        public Client client;


        public AccountBuilder client(Client client) {
            this.client = client;
            return this;
        }


        public Account build() {
            return new Account(client) {
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
            };

        }


    }
    @Override
    public String toString() {
        return "Count{" +
                "Client: " + client +
                ", number=" + number +
                '}';
    }
}
