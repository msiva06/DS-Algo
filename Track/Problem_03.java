// Design Tic Tac Toe
public class Problem_03 {
    int[][] board;
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    public Problem_03(int n) {
        board = new int[n][n];
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }

    // move will be used to play a move by a specific player and identify who
    // wins at each move
    public int move(int row, int col, int player) {
        int n = board.length;
        int currPlayer = -1;
       if(player == 1){
         currPlayer = 1;
       }
           rows[row] += currPlayer;
           cols[col] += currPlayer;
           if(row == col){
               diag += currPlayer;
           }
           if((row + col) == n-1)
           {
               antiDiag += currPlayer;
           }
           if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n)
            return player;
       
       return 0;

    }
}
