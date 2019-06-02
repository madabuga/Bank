import bank.Bank;
import bank.BankAccount;
import bank.Currency;

public class Main {

    public static void main(String[] args) {

        BankAccount B1 = new BankAccount("Andrei Popa", Currency.EUR);
        Bank.ING.registerBankAccount(B1);

        B1.depositMoney(200);
        B1.depositMoney(100.5, Currency.RON);

        B1.withdrawMoney(10.687);
        B1.withDrawMoney(1000, Currency.USD);
        B1.withDrawMoney(50, Currency.EUR);

        B1.creditCardNumber("172860093799245");

        BankAccount B2 = new BankAccount("Miruna Ionescu", Currency.YEN);
        Bank.ING.registerBankAccount(B2);
        B2.depositMoney(500, Currency.USD);
        B2.withDrawMoney(100, Currency.EUR);

        B2.creditCardNumber("5468050458400842");

    }
}
