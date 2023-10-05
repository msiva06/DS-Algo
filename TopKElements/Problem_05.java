package TopKElements;

import java.util.Arrays;
import java.util.PriorityQueue;

// Maximum subsequence score
public class Problem_05 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
            for(int i = 0; i < nums1.length; i++){
                pairs[i] = new int[] {nums1[i], nums2[i]};  
            }
        Arrays.sort(pairs,(a,b) -> b[1] - a[1]);
        PriorityQueue<Integer> topHeap = new PriorityQueue<Integer>((a,b) -> a - b);
        long sum = 0, min = 0;
        for(int i = 0; i < k; i++){
            sum += pairs[i][0];
            topHeap.add(pairs[i][0]);
        }
        min = pairs[k-1][1];
        long totalSum = sum * min;
        int i = k;
        while(i < pairs.length){
            sum -= topHeap.poll();
            sum += pairs[i][0];
            min = pairs[i][1];
            topHeap.add(pairs[i][0]);
            totalSum = Math.max(totalSum, sum * min);
            i++;
        }
        return totalSum;
    }
}
