import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayGame {

    Board board = new Board();

    // Off/ON-switch for while-loop. When running = true = ON, when running = false = OFF.
    boolean running = true;
    boolean isRunning = true;

    //All winning combinations in a 2D-array.
    int[][] winningCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    //Start on an invalid value.
    int number = -1;

    private Players player1;
    private Players player2;

    // Count how many times player 1 and player 2 wins.
    byte winnerCount1 = 0;
    byte winnerCount2 = 0;

    //
    public void gamePlay() {

        //Welcome message is printed out in terminal.
        System.out.println("\n" + "Welcome to Tic-Tac-Toe!" + "\n");

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {

            System.out.println("What is the name of player 1?");
            String name1 = scanner.nextLine();

            System.out.println("What is the name of player 2?");
            String name2 = scanner.nextLine();

            //Check so player 1 and player 2 doesn´t have the same name. If they have different name, the while-loop stops.
            if (name1.equalsIgnoreCase(name2)) {
                System.out.println("You can´t use the same name, please try again");
                continue;
            } else {
                isRunning = false;
            }
            player1 = new Players(name1, "X");
            player2 = new Players(name2, "O");

            //Welcome message with player 1 and player 2´s names.
            System.out.println("\n" + "Welcome " + player1.getName() + " and " + player2.getName() + "! \n" +
                    "Let´s begin!" + "\n");
        }

        // Prints the board with numbers to show the players which number sits att which place.
        board.numberGameBoard();

        //Boolean that makes it possible to change to false and that way switch players.
        boolean switchPlayer = true;

        while (running) {
            // currentPlayer switches in the end of loop to next player.
            Players currentPlayer = switchPlayer ? player1 : player2;

            // marker is X for player 1 and O for player 2.
            String marker = currentPlayer.getMarkers();

            System.out.println(currentPlayer.getName() + ": You are playing with " + marker + "-markers. Choose a number between 1-9!");

            //Player choose a number between 1-9. try/catch to catch any symbol that isn´t 1-9.
            try {
                number = scanner.nextInt();
                if (number < 1 || number > 9) {
                    System.out.println("Not a number between 1-9. Please choose again :)");
                    scanner.nextLine();
                    continue;
                }

                number = number - 1;
                // Add an "X" or an "O" on chosen square if the chosen square is null (empty) and the input number is between 1-9.
                if (board.xoBoardSlots[number] == null) {
                    board.xoBoardSlots[number] = marker;
                    board.printGameBoard();

                    //Check if the latest X made player 1 win. If so, reset the game and continue to play.
                    if (checkWinner(marker)) {
                        System.out.println(currentPlayer.getName() + " is the winner! Let's play again! \n");

                        if (currentPlayer == player1) {
                            winnerCount1++;
                        } else {
                            winnerCount2++;
                        }
                        System.out.println("Number of times " + player1.getName() + " has won: " + winnerCount1 + "!");
                        System.out.println("Number of times " + player2.getName() + " has won: " + winnerCount2 + "! \n");
                        board.resetGame();
                    }

                    //If slot is NOT empty, let player choose a new number.
                } else {
                    System.out.println("Number is unavailable, choose another number.");
                    board.printGameBoard();
                    continue;
                }
                //If player choose a symbol that is NOT a number. Error message. Let player choose a new number.
            } catch (InputMismatchException e) {
                System.out.println("That is not a number. Please choose a number between 1-9!");
                scanner.nextLine();
                continue;
            }

            //Check if 9 slots have been filled without a winner.
            checkTie();

            //Switch players. Now it´s player 2´s turn.
            switchPlayer = !switchPlayer;

        }
    }

    public boolean checkTie() {

        for (int i = 0; i < 9; i++) {
            if (board.xoBoardSlots[i] == null) {
                return false;
            }
        }
        System.out.println("It´s a tie! Let´s play again! \n");
        board.resetGame();
        return true;

    }

    //Checks if any of the combinations in the 2D-array winningCombinations if full, and if so, check if it has only X or O in it.
    public boolean checkWinner(String marker) {
        for (int[] combination : winningCombinations) {
            // Checks so the slots are NOT null.
            if (board.xoBoardSlots[combination[0]] != null &&
                    board.xoBoardSlots[combination[1]] != null &&
                    board.xoBoardSlots[combination[2]] != null) {

                // Check which player has a winning combination.
                if (board.xoBoardSlots[combination[0]].equals(marker) &&
                        board.xoBoardSlots[combination[1]].equals(marker) &&
                        board.xoBoardSlots[combination[2]].equals(marker))
                    return true;
            }
        }
        return false;
    }

}
