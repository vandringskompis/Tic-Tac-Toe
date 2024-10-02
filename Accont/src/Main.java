import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Jenny Karlsson", 5000.0);
        SavingsAccount savings = new SavingsAccount("Jack Smith", 3000.0, 4.45);

        System.out.println("Konto: savings. Hur mycket pengar vill du sätta in/ta ut. Anänd - för att ta ut.");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount < 0) {
            savings.withdraw(-amount);
        } else {
            savings.deposit(amount);
        }




        savings.deposit(100);
        savings.addInterest();
        System.out.println("I kontot 'savings' så är innehavet: " + savings.balance);

        System.out.println("Från vilket konto vill du föra över pengar från? (savings/account)");
        String fromNewAccount = scanner.nextLine();

        System.out.println("Från vilket konto vill du föra över pengar till? (savings/account)");
        String toNewAccount = scanner.nextLine();

        Account fromAccount = fromNewAccount.equalsIgnoreCase("savings") ? savings : account;
        Account toAccount = toNewAccount.equalsIgnoreCase("savings") ? savings : account;

        if (fromAccount == toAccount) {
            System.out.println("Du kan inte överföra pengar till samma konto.");
            return;
        }

        double newBalance = SavingsAccount.transfer(fromAccount, toAccount);

        System.out.println(combineToString(account, savings));

        scanner.close();

    }

    public static String combineToString(Account account, SavingsAccount savings) {
        return account.toString() + savings.toString();
    }

}