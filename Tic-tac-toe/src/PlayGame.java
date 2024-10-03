import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    Players players = new Players();

    Scanner scanner = new Scanner(System.in);

    // Array where the "X" and "O" will be stored.
    String[] XO = new String[9];

    // Off/ON-switch for while-loop. When running = true = ON, when running = false = OFF.
    boolean running = true;

    // Method to add an X or an O to the game board.
    public void addXO() {

        while (running) {

            System.out.println("Spelare 1. Skriv in en siffra");
            int number = scanner.nextInt();

            // Add an "X" on chosen square if the chosen square is null (empty) and the input number is between 0-8.
            if (number >= 0 && number < 9 && XO[number] == null) {
                XO[number] = "X";
                printGameBoard();

            } else {
                System.out.println("Ogiltigt val, försök igen");
                printGameBoard();
                continue;
            }

            System.out.println("Spelare 2. Skriv in en siffra");
            number = scanner.nextInt();

            // Add an "O" on chosen square if the chosen square is null (empty) and the input number is between 0-8.
            if (number >= 0 && number < 9 && XO[number] == null) {
                XO[number] = "O";
                printGameBoard();
            } else {
                running = false;
                printGameBoard();
                break;

            }
        }
    }

    public void numberGameBoard() {

        System.out.println("Here is the game board. You will have to choose a number between 0-8.");
        System.out.println("Down below you will see the placement of each number. Do well to remeber the number placements. Good luck!");
        System.out.println(" ");
        System.out.println("  " + "0" + " | " + "1" + " | " + "2" );
        System.out.println(" ---+---+---");
        System.out.println("  " + "3" + " | " + "4" + " | " + "5" );
        System.out.println("---+---+---");
        System.out.println("  " + "6" + " | " + "7" + " | " + "8" );
    }

    public void printGameBoard() {
        System.out.println("  " + ((XO[0] == null) ? " " : XO[0]) + " | " + ((XO[1] == null) ? " " : XO[1]) + " | " + ((XO[2] == null) ? " " : XO[2]));
        System.out.println(" ---+---+---");
        System.out.println("  " + ((XO[3] == null) ? " " : XO[3]) + " | " + ((XO[4] == null) ? " " : XO[4]) + " | " + ((XO[5] == null) ? " " : XO[5]));
        System.out.println("---+---+---");
        System.out.println("  " + ((XO[6] == null) ? " " : XO[6]) + " | " + ((XO[7] == null) ? " " : XO[7]) + " | " + ((XO[8] == null) ? " " : XO[8]));
    }
}


