import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Jenny Karlsson", 5000.0);
        System.out.println("Hur mycket pengar vill du sätta in/ta ut.");
        double amount = scanner.nextDouble();

        if (amount<0){
            account.withdraw(-amount);
        } else {
            account.deposit(amount);
        }

        System.out.println(account.toString());

        scanner.close();

    }
}