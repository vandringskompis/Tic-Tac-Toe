public class Board {

    // Array where the "X" and "O" will be stored.
    String[] xoBoardSlots = new String[9];

    //Print out "empty" board with numbers. So players can see which number represents which slot.
    public void numberGameBoard() {

        System.out.println("Here is the game board. You will have to choose a number between 1-9.");
        System.out.println("Down below you will see the placement of each number. Do well to remember the number placements. Good luck!");
        System.out.println(" ");
        System.out.println("  " + "1" + " | " + "2" + " | " + "3");
        System.out.println(" ---+---+---");
        System.out.println("  " + "4" + " | " + "5" + " | " + "6");
        System.out.println("---+---+---");
        System.out.println("  " + "7" + " | " + "8" + " | " + "9");
        System.out.println(" ");
    }

    // If xoBoardSlots[i] is empty then either an X or an O will be placed at that spot
    // If the spot is null then it will look empty in terminal. (ternery/ternär operator used instead of if-statements.)
    public void printGameBoard() {
        System.out.println(" ");
        System.out.println("  " + ((xoBoardSlots[0] == null) ? " " : xoBoardSlots[0]) + " | " + ((xoBoardSlots[1] == null) ? " " : xoBoardSlots[1]) + " | " + ((xoBoardSlots[2] == null) ? " " : xoBoardSlots[2]));
        System.out.println(" ---+---+---");
        System.out.println("  " + ((xoBoardSlots[3] == null) ? " " : xoBoardSlots[3]) + " | " + ((xoBoardSlots[4] == null) ? " " : xoBoardSlots[4]) + " | " + ((xoBoardSlots[5] == null) ? " " : xoBoardSlots[5]));
        System.out.println("---+---+---");
        System.out.println("  " + ((xoBoardSlots[6] == null) ? " " : xoBoardSlots[6]) + " | " + ((xoBoardSlots[7] == null) ? " " : xoBoardSlots[7]) + " | " + ((xoBoardSlots[8] == null) ? " " : xoBoardSlots[8]));
        System.out.println(" ");
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            xoBoardSlots[i] = null;
        }
    }
}
