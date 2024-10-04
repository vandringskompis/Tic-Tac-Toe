import java.util.ArrayList;
import java.util.Scanner;

public class Players {
   private String player1Name;
   private String player2Name;

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    // Method to add players. Asking what their names are and then print out a welcome message.
    public void addPlayers() {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("What is the name of player 1?");
            player1Name = scanner.nextLine();
            System.out.println("What is the name of player 2?");
            player2Name = scanner.nextLine();

            if (player2Name.equalsIgnoreCase(player1Name)) {
                System.out.println("You can´t use the same name, please try again");
                continue;
            } else {
                running = false;
            }

            System.out.println("\n" + "Welcome " + player1Name + " and " + player2Name + "! \n" +
                    "Let´s begin!" + "\n");
        }

    }
}

