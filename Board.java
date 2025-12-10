
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

// check if a player has won
public boolean checkWin(char mark) {

    // check rows
    for (int r = 0; r < SIZE; r++) {
        if (board[r][0] == mark && board[r][1] == mark && board[r][2] == mark)
            return true;
    }

    // check columns
    for (int c = 0; c < SIZE; c++) {
        if (board[0][c] == mark && board[1][c] == mark && board[2][c] == mark)
            return true;
    }

    // check diagonal top-left → bottom-right
    if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark)
        return true;

    // check diagonal top-right → bottom-left
    if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)
        return true;

    return false;
}


// check if board is full
public boolean boardFull() {
    for (int r = 0; r < SIZE; r++) {
        for (int c = 0; c < SIZE; c++) {
            if (board[r][c] == '-') {   // still empty
                return false;
            }
        }
    }
    return true;
}


}
