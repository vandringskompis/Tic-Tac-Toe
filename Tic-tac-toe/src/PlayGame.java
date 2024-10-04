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
    int number = -1;

    // Method to add an X or an O to the game board.
    public void gamePlay() {

        //Metod från Class Players that adds two players to the game.
        players.addPlayers();

        // Prints the board with numbers to show the players which number sits att which place.
        board.numberGameBoard();

        boolean switchPlayer = true;

        while (running) {


            if (switchPlayer) {

                System.out.println(players.getPlayer1Name() + ": Choose a number between 0-8!");

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

                        if (checkWinner("X")) {
                            System.out.println("Player 1 is the winner! Let's play again! \n");
                            resetGame();
                        }

                    } else {
                        System.out.println("Number is unavailable, choose another number.");
                        board.printGameBoard();
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That is not a number. Please choose a number between 0-8!");
                    scanner.nextLine();
                    continue;
                }

                checkTie();

                switchPlayer = !switchPlayer;

            } else {

                System.out.println(players.getPlayer2Name() + ": Choose a number between 0-8!");

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
                        board.

                                printGameBoard();

                        if (checkWinner("O")) {
                            System.out.println("Player 2 is the winner! Let's play again!\n");
                            resetGame();

                        }

                    } else {
                        System.out.println("Number is unavailable, choose another number.");
                        continue;
                    }
                } catch (
                        InputMismatchException e) {
                    System.out.println("That is not a number. Please choose a number between 0-8!");
                    scanner.nextLine();
                    continue;
                }
                checkTie();

                switchPlayer = !switchPlayer;
            }
        }
    }

    public boolean checkTie() {
        boolean boardIsFull = true;

        for (int i = 0; i < 9; i++) {
            if (board.xoBoardSlots[i] == null) {
                boardIsFull = false;
                break;
            }
        }

        if (boardIsFull) {
            System.out.println("It´s a tie! Let´s play again!");
            resetGame();
            return true;

        }
        return false;
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

                // Check if player 1 has a winning combination.
                if (board.xoBoardSlots[combination[0]].equals(marker) &&
                        board.xoBoardSlots[combination[1]].equals(marker) &&
                        board.xoBoardSlots[combination[2]].equals(marker))
                    return true;
            }
        }
        return false;
    }
}
