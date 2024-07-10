package BankComponents;

public class Client {

    private String name;
    private String address;
    private String phone;
    private String email;
    private String CPF;

    private double balance;

    private Client(String name, String address, String phone, String email, String CPF, double balance) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.CPF = CPF;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double value) {
        if(value > 0) {
            double ActualBalance = this.getBalance();
            ActualBalance += value;
            this.balance = ActualBalance;
        }
        else{
            throw new RuntimeException("Invalid value");
        }
    }

    public void withdraw(double value) {
        if (this.getBalance() >= value) {
            this.balance -= value;
        } else {
            throw new RuntimeException("Insufficient balance.");
        }
    }

    public void transfer(double value) {
        if (this.getBalance() >= value) {
            this.withdraw(value);

        } else {
            throw new RuntimeException("Insufficient balance for transfer");
        }
    }

    public void printStatement() {
        System.out.println("=== Account Balance ===");
        System.out.println(this);
    }

    public static class ClientBuilder {
        private String name;
        private String address;
        private String phone;
        private String email;
        private String CPF;
        private double balance;

        public ClientBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder address(String address) {
            this.address = address;
            return this;
        }

        public ClientBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public ClientBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder CPF(String CPF) {
            this.CPF = CPF;
            return this;
        }



        public Client build() {
            return new Client(name, address, phone, email, CPF, balance);
        }
    }
}
