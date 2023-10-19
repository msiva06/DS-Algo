package Matrices;

// Where will the ball fall
public class Problem_05 {
    public static int[] findExitColumn(int[][] grid) {
        int[] res = new int[grid[0].length];
        for(int col = 0; col < grid[0].length; col++){
            int currCol = col;
            for(int row = 0; row < grid.length; row++){
                int nextCol = currCol + grid[row][currCol];
                if(nextCol < 0 || nextCol == grid[0].length || grid[row][nextCol] != grid[row][currCol])
                {
                    res[col] = -1;
                    break;
                }
                res[col] = nextCol;
                currCol = nextCol;
            }
        }
        return res;
    }
}
