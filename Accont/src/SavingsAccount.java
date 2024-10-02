
import java.util.Scanner;


public class SavingsAccount extends Account {
    Scanner scanner = new Scanner(System.in);
    private double interestRate;

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount(String name, double balance, double interestRate) {
        super(name, balance);
        this.interestRate = interestRate;
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void addInterest() {
        double balance = getBalance();
        double interest = balance * (interestRate / 100);
        deposit(interest);
    }

    public String toString() {
        return "\nOwner of account: " + this.getName() + ".\n" +
                "Balance: " + balance + "sek. \n" +
                "Current interest rate: " +
                interestRate + "\n";

    }

    public static double transfer(Account fromAccount, Account toAccount) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hur mycket pengar vill du föra över?");
        double transferMoney = scanner.nextDouble();

        if (fromAccount.getBalance() >= transferMoney) {
            // Gör överföringen
            fromAccount.withdraw(transferMoney);
            toAccount.deposit(transferMoney);


            return fromAccount.getBalance();
        } else {
            System.out.println("Du har inte tillräckligt på kontot för att genomföra överföringen.");
            return fromAccount.getBalance();
        }
    }
}
