package Matrices;

import java.util.ArrayList;
import java.util.List;

// Spiral Matrix
public class Problem_04 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = 0, col = -1;
        int rows = matrix.length, cols = matrix[0].length;
        int direction = 1;
        List<Integer> res = new ArrayList<Integer>();
        while(rows > 0 && cols > 0){
            for(int i = 0; i < cols; i++){
                col += direction;
                res.add(matrix[row][col]);
            }
            rows -= 1;
            for(int i = 0; i < rows; i++){
                row += direction;
                res.add(matrix[row][col]);
            }
            cols -= 1;
            direction *= -1;
        }
        return res;
    }
}
