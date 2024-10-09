//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();

        System.out.println("\nWelcome to tic-tac-toe!\n" +
                "\nThe rules are as following: \n" +
                "Each player will have a chance to place a marker during each turn." +
                "\nIn order to win, you will have to place your marker three in a row, either horizontally, vertically or diagonally. \n" +
                "Let´s start with your names! \n");

        //The game starts.
        playGame.gamePlay();

    }
}