//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();
        Players players = new Players();
//Funkarfunkars
        System.out.println("\nc" + "Welcome to Tic-Tac-Toe" + "\n");
        players.addPlayers();
        gameBoard.printGameBoard();
        }
    }