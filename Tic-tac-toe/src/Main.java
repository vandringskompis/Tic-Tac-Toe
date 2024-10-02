//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();
        Players players = new Players();

        System.out.println("\n" + "Welcome to Tic-Tac-Toe" + "\n");

//TestestTestTest
        players.addPlayers();
        gameBoard.printGameBoard();
        }
    }