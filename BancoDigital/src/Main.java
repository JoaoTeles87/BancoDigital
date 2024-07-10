import BankComponents.Bank;
import BankComponents.Client;
import AccountConstruction.Account;
import AccountConstruction.CurrentAccount;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Client cliente1 = new Client.ClientBuilder()
                .name("João")
                .address("Rua do Ouvidor, 123")
                .phone("0800 123 4567")
                .email("jant@cin.ufpe.br")
                .CPF("12345678910")
                .balance(1000)
                .build();
        CurrentAccount count2 = new CurrentAccount.CurrentAccountBuilder()
                .client(cliente1)
                .build();

        Bank Santander = new Bank.BankBuilder()
                .name("Santander")
                .address("Rua do Ouvidor, 123")
                .phone("0800 123 4567")
                .email("santandersuport@gmail.com")
                .website("www.santander.com.br")
                .counts(List.of(count2))
                .build();


        System.out.println(Santander);

    }
}