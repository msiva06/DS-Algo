package Matrices;

// Set Matrix zeroes
public class Problem_01 {
    public static int[][] setMatrixZeros(int[][] mat) {
      
        int rows = mat.length;
        int cols = mat[0].length;
        boolean isCol = false;
        for(int row = 0; row < rows; row++){
           if(mat[row][0] == 0)
              isCol = true;
           for(int col = 1; col < cols; col++){
              if(mat[row][col] == 0)
              {
                 mat[row][0] = 0;
                 mat[0][col] = 0;
              }
           }
        }
        for(int row = 1; row < rows; row++){
           for(int col = 1; col < cols; col++){
              if(mat[row][0] == 0 || mat[0][col] == 0){
                 mat[row][col] = 0;
              }
           }
        }
        if(mat[0][0] == 0){
           for(int col = 0; col < cols; col++)
              mat[0][col] = 0;
        }
        if(isCol){
           for(int row = 0; row < rows; row++)
              mat[row][0] = 0;
        }
        return mat;
     }
}
