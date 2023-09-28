package TwoHeaps;

import java.util.PriorityQueue;

// Maximize capital
public class Problem_01 {
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int currCapital = c;
        PriorityQueue<int[]> minCapHeap = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        for(int i = 0; i < capitals.length; i++)
            minCapHeap.offer(new int[]{capitals[i],i});
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        int i = 0;
        while(i < k){
            while(!minCapHeap.isEmpty() && minCapHeap.peek()[0] <= currCapital){
                int capIndex = minCapHeap.poll()[1];
                maxProfitHeap.offer(new int[]{profits[capIndex],capIndex});
            }
            if(maxProfitHeap.isEmpty())
                break;
            currCapital += maxProfitHeap.poll()[0];
            i++;
        }
        return currCapital;
    }
}
