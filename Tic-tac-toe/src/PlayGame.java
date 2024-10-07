import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayGame {

    Players players = new Players();
    Board board = new Board();

    Scanner scanner = new Scanner(System.in);

    // Off/ON-switch for while-loop. When running = true = ON, when running = false = OFF.
    boolean running = true;

    //All winning combinations in a 2D-array.
    int[][] winningCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    //Start on an invalid value.
    int number = -1;

    byte winnerCount1 = 0;
    byte winnerCount2 = 0;

    // Method to add an X or an O to the game board.
    public void gamePlay() {

        //Welcome message is printed out in terminal.
        System.out.println("\n" + "Welcome to Tic-Tac-Toe!" + "\n");

        //Metod från Class Players that adds two players to the game.
        players.addPlayers();

        // Prints the board with numbers to show the players which number sits att which place.
        board.numberGameBoard();

        //Boolean that makes it possible to change to false and that way switch players.
        boolean switchPlayer = true;

        while (running) {

            if (switchPlayer) {

                System.out.println(players.getPlayer1Name() + ": You are playing with X-markers. Choose a number between 0-8!");

                //First player choose a number between 0-8. try/catch to catch any symbol that isn´t 0-8.
                try {
                    number = scanner.nextInt();
                    if (number < 0 || number > 8) {
                        System.out.println("Not a number between 0-8. Please choose again :)");
                        scanner.nextLine();
                        continue;
                    }

                    // Add an "X" on chosen square if the chosen square is null (empty) and the input number is between 0-8.
                    if (board.xoBoardSlots[number] == null) {
                        board.xoBoardSlots[number] = "X";
                        board.printGameBoard();

                        //Check if the latest X made player 1 win. If so, reset the game and continue to play.
                        if (checkWinner("X")) {
                            System.out.println(players.getPlayer1Name() + " is the winner! Let's play again! \n");
                            winnerCount1++;
                            System.out.println("Number of times " + players.getPlayer1Name() + " has won: "  + winnerCount1 + "!");
                            System.out.println("Number of times " + players.getPlayer2Name() + " has won: "  + winnerCount2 + "! \n");
                            resetGame();
                        }

                        //If slot is NOT empty, let player choose a new number.
                    } else {
                        System.out.println("Number is unavailable, choose another number.");
                        board.printGameBoard();
                        continue;
                    }
                    //If player choose a symbol that is NOT a number. Error message. Let player choose a new number.
                } catch (InputMismatchException e) {
                    System.out.println("That is not a number. Please choose a number between 0-8!");
                    scanner.nextLine();
                    continue;
                }

                //Check if 9 slots have been filled without a winner.
                checkTie();

                //Switch players. Now it´s player 2´s turn.
                switchPlayer = !switchPlayer;

                //else = (if switchPlayer = false (!switchPlayer) then player 2 is playing).
            } else {
                System.out.println(players.getPlayer2Name() + ": You are playing with O-markers. Choose a number between 0-8!");

                try {

                    number = scanner.nextInt();
                    if (number < 0 || number > 8) {
                        System.out.println("Not a number between 0-8. Please choose again :)");
                        scanner.nextLine();
                        continue;
                    }
                    // Add an "O" on chosen square if the chosen square is null (empty) and the input number is between 0-8.
                    if (board.xoBoardSlots[number] == null) {
                        board.xoBoardSlots[number] = "O";
                        board.printGameBoard();

                        if (checkWinner("O")) {
                            System.out.println(players.getPlayer2Name() + " is the winner! Let's play again!\n");
                            winnerCount2++;
                            System.out.println("Number of times " + players.getPlayer1Name() + " has won: "  + winnerCount1 + "!");
                            System.out.println("Number of times " + players.getPlayer2Name() + " has won: "  + winnerCount2 + "! \n");
                            resetGame();
                        }

                    } else {
                        System.out.println("Number is unavailable, choose another number.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That is not a number. Please choose a number between 0-8!");
                    scanner.nextLine();
                    continue;
                }
                checkTie();

                //Changes player.
                switchPlayer = !switchPlayer;
            }
        }
    }

    public boolean checkTie() {

        for (int i = 0; i < 9; i++) {
            if (board.xoBoardSlots[i] == null) {
                return false;
            }
        }
            System.out.println("It´s a tie! Let´s play again! \n");
            resetGame();
            return true;

        }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            board.xoBoardSlots[i] = null;
        }
    }

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
