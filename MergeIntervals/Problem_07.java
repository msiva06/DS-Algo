package MergeIntervals;

import java.util.Arrays;

// Non Overlapping Intervals
public class Problem_07 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int ans = 0;
        int k = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] >= k){
                k = intervals[i][1];
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}
