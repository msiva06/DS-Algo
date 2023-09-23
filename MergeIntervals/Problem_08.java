package MergeIntervals;

import java.util.Arrays;

// Min no. of arrows to burst balloons
public class Problem_08 {
    public int findMinArrowShots(int[][] points) {
      Arrays.sort(points, (a,b) -> {
        if(a[1] < b[1]) return -1;
        if(a[1] == b[1]) return 0;
        return 1;
      });
      int prevEnd = points[0][1];
      int burstCount = 1;
      for(int i = 0; i < points.length; i++){
        int xStart = points[i][0];
        int xEnd = points[i][1];
          if(prevEnd < xStart){
              burstCount++;
              prevEnd = xEnd;
          }             
      }
      return burstCount;
      
    }
}
