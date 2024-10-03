import java.util.Scanner;

public class PlayGame {
    Players players = new Players();

    Scanner scanner = new Scanner(System.in);

    // Array where the "X" and "O" will be stored.
    String[] xoBoardSlots = new String[9];

    // Off/ON-switch for while-loop. When running = true = ON, when running = false = OFF.
    boolean running = true;

    //All winning combinations in a 2D-array.
    int[][] winningCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


    // Method to add an X or an O to the game board.
    public void addXO() {

        while (running) {
            //Loop through the different winning combinations to see if there is a winner.

            System.out.println("Player 1: Choose a number between 0-8.");
            int number = scanner.nextInt();

            // Add an "X" on chosen square if the chosen square is null (empty) and the input number is between 0-8.
            if (number >= 0 && number < 9 && xoBoardSlots[number] == null) {
                xoBoardSlots[number] = "X";
                printGameBoard();

                for (int[] combination : winningCombinations) {
                    // Checks so the slots are NOT null.
                    if (xoBoardSlots[combination[0]] != null &&
                            xoBoardSlots[combination[1]] != null &&
                            xoBoardSlots[combination[2]] != null) {

                        // Check if player 1 has a winning combination.
                        if (xoBoardSlots[combination[0]].equals("X") &&
                                xoBoardSlots[combination[1]].equals("X") &&
                                xoBoardSlots[combination[2]].equals("X")) {
                            System.out.println("Player 1 is the winner");
                            running = false;
                            return;
                        }
                    }
                }

            } else {
                System.out.println("Number is unavailable, choose another number.");
                printGameBoard();
                continue;
            }


            System.out.println("Spelare 2. Skriv in en siffra");
            number = scanner.nextInt();

            // Add an "O" on chosen square if the chosen square is null (empty) and the input number is between 0-8.
            if (number >= 0 && number < 9 && xoBoardSlots[number] == null) {
                xoBoardSlots[number] = "O";
                printGameBoard();

                for (int[] combination : winningCombinations) {
                    if (xoBoardSlots[combination[0]] != null &&
                            xoBoardSlots[combination[1]] != null &&
                            xoBoardSlots[combination[2]] != null) {

                        if (xoBoardSlots[combination[0]].equals("O") &&
                                xoBoardSlots[combination[1]].equals("O") &&
                                xoBoardSlots[combination[2]].equals("O")) {
                            System.out.println("Player 2 is the winner");
                            running = false;
                            return;

                        }
                    }
                }
            } else {
                System.out.println("Number is unavailable, choose another number.");
                continue;
            }

        }

    }

    public void numberGameBoard() {

        System.out.println("Here is the game board. You will have to choose a number between 0-8.");
        System.out.println("Down below you will see the placement of each number. Do well to remember the number placements. Good luck!");
        System.out.println(" ");
        System.out.println("  " + "0" + " | " + "1" + " | " + "2");
        System.out.println(" ---+---+---");
        System.out.println("  " + "3" + " | " + "4" + " | " + "5");
        System.out.println("---+---+---");
        System.out.println("  " + "6" + " | " + "7" + " | " + "8");
    }

    // If xoBoardSlots[i] is empty then either an X or an O will be placed at that spot. If the spot is null then it will look empty in terminal. (ternery/ternär operator used)
    public void printGameBoard() {
        System.out.println("  " + ((xoBoardSlots[0] == null) ? " " : xoBoardSlots[0]) + " | " + ((xoBoardSlots[1] == null) ? " " : xoBoardSlots[1]) + " | " + ((xoBoardSlots[2] == null) ? " " : xoBoardSlots[2]));
        System.out.println(" ---+---+---");
        System.out.println("  " + ((xoBoardSlots[3] == null) ? " " : xoBoardSlots[3]) + " | " + ((xoBoardSlots[4] == null) ? " " : xoBoardSlots[4]) + " | " + ((xoBoardSlots[5] == null) ? " " : xoBoardSlots[5]));
        System.out.println("---+---+---");
        System.out.println("  " + ((xoBoardSlots[6] == null) ? " " : xoBoardSlots[6]) + " | " + ((xoBoardSlots[7] == null) ? " " : xoBoardSlots[7]) + " | " + ((xoBoardSlots[8] == null) ? " " : xoBoardSlots[8]));
    }

}




