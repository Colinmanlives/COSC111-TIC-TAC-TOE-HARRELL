
public class Board {

    private char[][] board;

    private final int SIZE = 3;

    public Board() {

        this.board = new char[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {

            for (int c = 0; c < SIZE; c++) {
                board[r][c] = '-';

            }

        }

    }

    public void displayBoard() {

        for (int r = 0; r < SIZE; r++) {

            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r][c] + " ");

            }
            System.out.println();

        }

    }

    public boolean moveChecker(int r,int c, char mark ) {

        if (r < 0 || r >= SIZE || c < 0 || c >= SIZE){
            return false;
        }

        if (board[r][c] != '-'){
            return false;
        }
    
            board [r][c] = mark;
    
    
    return true;

    }
}
