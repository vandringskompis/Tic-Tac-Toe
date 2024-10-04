//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Players players = new Players();
        PlayGame playGame = new PlayGame();

        //Welcome message is printed out in terminal.
        System.out.println("\n" + "Welcome to Tic-Tac-Toe" + "\n");

        //The game starts. All methods from PLayers and PlayGame is inside.
        playGame.gamePlay();

    }
}