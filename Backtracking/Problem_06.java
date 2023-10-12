package Backtracking;

public class Problem_06 {
    public static char[][] solveSudoku(char[][] board) {
        solve(board);
        return board;
    }

    public static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(i,j,board,c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }
                            else
                            {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
                  
            }
        }
        return true;
    }

    public static boolean isValid(int row,int col,char[][] board,char c){
        for(int k = 0; k < 9; k++){
            if(board[row][k] == c)
                return false;
            if(board[k][col] == c)
                return false;
            if(board[3 * (row / 3) + (k / 3)][3 * (col / 3) + (k % 3)] == c)
                return false;
        }
        return true;
    }
}
