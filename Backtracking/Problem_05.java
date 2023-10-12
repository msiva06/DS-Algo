package Backtracking;

// Flood fill
public class Problem_05 {
    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        if(target == grid[sr][sc])
            return grid;
        backtrack(grid,sr,sc,grid[sr][sc],target);
        return grid;
    }

    public static void backtrack(int[][] grid,int row,int col,int startValue,int target){
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length)
            return;
        if(grid[row][col] != startValue){
            return;
        }

        grid[row][col] = target;
        int[][] offset = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int[] off : offset){
            int rowOff = off[0];
            int colOff = off[1];
            backtrack(grid,row + rowOff,col + colOff,startValue,target);
        }
    }
}
