import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayGame {

    Board board = new Board();

    // Off/ON-switch for while-loops.
    boolean running = true;
    boolean isRunning = true;

    //All winning combinations in a 2D-array.
    int[][] winningCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    //Start on an invalid value.
    int number = -1;
    int numberOfPlayers = -1;

    private Players player1;
    private Players player2;
    private Players player3;
    private Players player4;

    // Count how many times player 1 and player 2 wins.
    int winnerCount1 = 0;
    int winnerCount2 = 0;
    int tieCount = 0;

    //Game-code
    public void gamePlay() {
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Are you 1 or 2 players?");
            try {
                numberOfPlayers = scanner.nextInt();
                scanner.nextLine();

                if (numberOfPlayers < 1 || numberOfPlayers > 2) {
                    System.out.println("Please choose number 1 or number 2.\n");
                    continue;
                }

                if (numberOfPlayers == 1) {
                    System.out.println("What is the name of player 1?");
                    String name = scanner.nextLine();

                    if (name.equalsIgnoreCase("Computer")) {
                        System.out.println("\nYou can´t use the same name, please try again.\n");
                        continue;
                    } else {
                        isRunning = false;
                    }

                    //create player3 and player4(computer).
                    player3 = new Players(name, "X");
                    player4 = new Players("Computer", "O");
                    System.out.println("\n" + "Welcome " + player3.getName() + " and " + player4.getName() + "! \n" +
                            "Let´s begin!" + "\n");


                } else {
                    System.out.println("What is the name of player 1?");
                    String name1 = scanner.nextLine();

                    System.out.println("What is the name of player 2?");
                    String name2 = scanner.nextLine();

                    //Check so player 1 and player 2 doesn´t have the same name. If they have different name, the while-loop stops.
                    if (name1.equalsIgnoreCase(name2)) {
                        System.out.println("You can´t use the same name, please try again. \n");
                        continue;
                    } else {
                        isRunning = false;
                    }
                    //create two new players. Player 1 and player 2.
                    player1 = new Players(name1, "X");
                    player2 = new Players(name2, "O");

                    //Welcome message with player 1 and player 2´s names.
                    System.out.println("\n" + "Welcome " + player1.getName() + " and " + player2.getName() + "! \n" +
                            "Let´s begin!" + "\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not a number. Please choose a number between 1-9! \n");
                scanner.nextLine();
            }
        }

        // Prints the board with numbers to show the players which number sits at which place.
        board.numberGameBoard();

        //Boolean that makes it possible to change to false and that way switch players.
        boolean switchPlayer = true;

        while (running) {
            // currentPlayer switches in the end of loop to next player. CurrentPlayer keeps track on which player is playing now.
            Players currentPlayer;

            //currentPlayer can be either player1 and 2 OR player3 and 4.
            if (player1 == null) {
                currentPlayer = switchPlayer ? player3 : player4;

            } else {

                currentPlayer = switchPlayer ? player1 : player2;
            }

            // marker is X for player 1 and O for player 2.
            String marker = currentPlayer.getMarkers();

            //ComputerPlayers moves.
            if (currentPlayer == player4) {

                int computerNumber;
                boolean computerValidNumber = false;

                System.out.println("Computer: You are playing with O-markers. Choose a number between 1-9!\n ");

                //Computer use Math.random to "choose" a number. Checks so the number is not full in array, after enters the O-mark in array.
                // Else it chooses a number until it finds an empty spot.
                while (!computerValidNumber) {
                    computerNumber = (int) (Math.random() * 9);
                    if (board.xoBoardSlots[computerNumber] == null) {
                        board.xoBoardSlots[computerNumber] = marker;
                        computerValidNumber = true;
                    }
                }
                //Prints where the computer put their O on the board.
                board.printGameBoard();
                if (checkWinner(marker)) {
                    System.out.println(currentPlayer.getName() + " is the winner! Let's play again! \n");

                    winnerCount2++;
                    countMessage();
                    board.resetGame();
                }
                    checkTie();

                    //Switch players
                    switchPlayer = !switchPlayer;


            } else {
                System.out.println(currentPlayer.getName() + ": You are playing with " + marker + "-markers. Choose a number between 1-9!");

                //Player choose a number between 1-9. try/catch to catch any symbol that isn´t 1-9.
                try {
                    number = scanner.nextInt();
                    if (number < 1 || number > 9) {
                        System.out.println("Not a number between 1-9. Please choose again. \n");
                        scanner.nextLine();
                        continue;
                    }

                    number = number - 1;
                    // Add an "X" or an "O" on chosen square if the chosen square is null (empty) and the input number is between 1-9.
                    if (board.xoBoardSlots[number] == null) {
                        board.xoBoardSlots[number] = marker;
                        board.printGameBoard();

                        //Check win.
                        if (checkWinner(marker)) {
                            System.out.println(currentPlayer.getName() + " is the winner! Let's play again! \n");

                            if (currentPlayer == player1 || currentPlayer == player3) {
                                winnerCount1++;
                            } else {
                                winnerCount2++;
                            }
                            countMessage();
                            board.resetGame();
                        }

                        //If slot is NOT empty, let player choose a new number. Also writes out which number is not available.
                    } else {
                        System.out.println("The number " + (number + 1) + " is unavailable, choose another number. \n");
                        board.printGameBoard();
                        continue;
                    }
                    //If player choose a symbol that is NOT a number. Error message. Let player choose a new number.
                } catch (InputMismatchException e) {
                    System.out.println("That is not a number. Please choose a number between 1-9! \n");
                    scanner.nextLine();
                    continue;
                }

                checkTie();

                //Switch players
                switchPlayer = !switchPlayer;

            }
        }
    }

    // Checks if all slots have been filled and announce a tie. checkTie lies after checkWin() to make sure game doesn´t miss a win.
    public boolean checkTie() {

        for (int i = 0; i < 9; i++) {
            if (board.xoBoardSlots[i] == null) {
                return false;
            }
        }
        System.out.println("It´s a tie! Let´s play again! \n");
        tieCount++;
        board.resetGame();
        countMessage();
        return true;
    }

    //Checks if any of the combinations in the 2D-array winningCombinations if full, and if so, check if it has only X or O in it.
    public boolean checkWinner(String marker) {
        for (int[] combination : winningCombinations) {
            // Checks so the slots are NOT null.
            if (board.xoBoardSlots[combination[0]] != null &&
                    board.xoBoardSlots[combination[1]] != null &&
                    board.xoBoardSlots[combination[2]] != null) {

                // Check if the same marker is in the combination.
                if (board.xoBoardSlots[combination[0]].equals(marker) &&
                        board.xoBoardSlots[combination[1]].equals(marker) &&
                        board.xoBoardSlots[combination[2]].equals(marker))
                    return true;
            }
        }
        return false;
    }

    public void countMessage() {

        Players currentPlayers1 = (player1 == null) ? player3 : player1;
        Players currentPlayers2 = (player2 == null) ? player4 : player2;

        System.out.println("Number of times " + currentPlayers1.getName() + " has won: " + winnerCount1 + "!");
        System.out.println("Number of times " + currentPlayers2.getName() + " has won: " + winnerCount2 + "!");
        System.out.println("Number of times there has been a tie: " + tieCount + "\n");
    }
}
