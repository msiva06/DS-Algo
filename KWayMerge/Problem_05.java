package KWayMerge;

import java.util.PriorityQueue;

// Kth smallest element in a sorted matrix
public class Problem_05 {
   public static int kthSmallestElement(int[][] matrix, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i = 0; i < matrix.length ;i++){
            minHeap.offer(new int[]{matrix[i][0],i,0});
        }
        int smallNum = 0 , rowIndex = 0,colIndex = 0;
        while(!minHeap.isEmpty() && k > 0){
            int[] smallest = minHeap.poll();
            smallNum = smallest[0];
            rowIndex = smallest[1];
            colIndex = smallest[2];
            if(colIndex + 1 < matrix[0].length)
                minHeap.offer(new int[] {matrix[rowIndex][colIndex+1], rowIndex,colIndex+1});
            k--;
        }
        return smallNum;
    } 
}
