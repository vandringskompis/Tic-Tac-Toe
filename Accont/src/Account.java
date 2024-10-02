public class Account {
    private String name;
    double balance;


    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
        this.balance = 0;
    }

    public Account(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getBalance(){
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
    public String toString() {
        return "Owner of account: " + this.getName() + "." +
                "\nBalance: " + balance + " sek. \n";
    }

    }
