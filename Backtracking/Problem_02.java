package Backtracking;

// Word Search
public class Problem_02 {
    public static boolean wordSearch(char[][] grid, String word) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(backtrack(row,col,grid,word))
                    return true;
            }
        }
        return false;
    }

    public static boolean backtrack(int row,int col, char[][] grid,String word){
        if(word.length() == 0)  
            return true;
        
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != word.charAt(0)){
            return false;
        }

        grid[row][col] = '*';
        boolean res = false;
        int[][] offset = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] off:offset){
            int oRow = off[0];
            int oCol = off[1];
            res = backtrack(row+oRow, col + oCol, grid, word.substring(1));
            if(res)
                break;
        }
        grid[row][col] = word.charAt(0);
        return res;
    }
}
