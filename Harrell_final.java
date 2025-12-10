//author colin harrell      date 11/21/25
// tic tac toe final project

import java.util.Scanner;

public class Harrell_final {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        while (true) {

            Board board = new Board();
            char currentPlayer = 'X';

            while (true) {

                board.displayBoard();

                if (currentPlayer == 'X') {
                    System.out.println("Your turn (X)");
                    xPlacement(board, kb);
                } else {
                    System.out.println("Computer (O) is thinking...");
                    oPlacement(board);
                }

                // check win status
                if (board.checkWin(currentPlayer)) {
                    board.displayBoard();
                    if (currentPlayer == 'X') {
                        System.out.println("YOU WIN!"); 
                    }else {
                        System.out.println("COMPUTER WINS!");
                    }

                    if (!playAgain(kb)) {
                        break;
                    } else {
                        //Board board2 = new Board();
                        //char newPlayer = 'X';
                        main(args);
                        continue;
                    }

                }

                // check tie
                if (board.boardFull()) {
                    board.displayBoard();
                    System.out.println("IT'S A TIE!");

                    if (!playAgain(kb)) {
                        break;
                    } else {
                        //Board board2 = new Board();
                        //char newPlayer = 'X';
                        main(args);
                        continue;
                    }
                }

                // switch turns
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

    }

    // creating method for player input
    public static void xPlacement(Board b, Scanner kb2) {

        System.out.print(" please enter row cordinate 0-2: ");
        int row = kb2.nextInt();
        System.out.print(" please enter column cordinate 0-2: ");
        int column = kb2.nextInt();

        b.moveChecker(row, column, 'X');
    }

// Computer input
    public static void oPlacement(Board b) {

        // random move placer
        java.util.Random rand = new java.util.Random();
        int row, column;

        while (true) {
            row = rand.nextInt(3);     // 0–2
            column = rand.nextInt(3);  // 0–2

            // Try the move. If valid, break.
            if (b.moveChecker(row, column, 'O')) {
                System.out.println("Computer (O) placed at: " + row + ", " + column);
                break;
            }
        }
    }

    public static boolean playAgain(Scanner kb) {
        System.out.print("Would you like to play again? (y/n): ");
        String answer = kb.next().toLowerCase();

        return answer.equals("y") || answer.equals("yes");
    }

}
