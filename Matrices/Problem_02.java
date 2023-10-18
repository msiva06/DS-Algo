package Matrices;

// Rotate Image
public class Problem_02 {
    public static int[][] rotateImage(int[][] matrix) {

        int n = matrix.length;
        for(int i = 0;i < n/2; i++){
            for(int j = i; j < n - i -1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
  
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = temp;
  
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }
        return matrix;
      }
}
