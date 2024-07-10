package BankComponents;

import AccountConstruction.Account;
import java.util.List;

public class Bank {
    protected String name;
    protected String address;
    protected String phone;
    protected String email;
    protected String website;
    protected List<Account> counts;

    private Bank(String name, String address, String phone, String email, String website, List<Account> counts) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.counts = counts;
    }

    public static class BankBuilder {
        private String name;
        private String address;
        private String phone;
        private String email;
        private String website;
        private List<Account> counts;

        public BankBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BankBuilder address(String address) {
            this.address = address;
            return this;
        }

        public BankBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public BankBuilder email(String email) {
            this.email = email;
            return this;
        }

        public BankBuilder website(String website) {
            this.website = website;
            return this;
        }

        public BankBuilder counts(List<Account> counts) {
            this.counts = counts;
            return this;
        }

        public BankBuilder addCount(Account count) {
            if (this.counts != null) {
                this.counts.add(count);
            }
            return this;
        }

        public Bank build() {
            return new Bank(name, address, phone, email, website, counts);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", counts=" + counts +
                '}';
    }
}
