import java.util.ArrayList;
import java.util.Scanner;
//ud
public class Players {

    //Add arrayList to add players to.
    ArrayList<String> players = new ArrayList<>();

    // Method to add players. Asking what their names are and then print out a welcome message.
    public void addPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of player 1?");
        String player1 = scanner.nextLine();
        players.add(player1);
        System.out.println("What is the name of player 2?");
        String player2 = scanner.nextLine();
        players.add(player2);

        System.out.println("\n" + "Welcome " + player1 + " and " + player2 + "! \n" +
                "Let´s begin!" + "\n");
    }
}
