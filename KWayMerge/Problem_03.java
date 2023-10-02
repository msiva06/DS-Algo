package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// K pairs with smallest sums
public class Problem_03 {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        PriorityQueue<int[]> pair = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<List<Integer>> pairs = new ArrayList<>();
        int l1 = 0, l2 = 0;
        while(l1 < list1.length){
            l2 = 0;
            while(l2 < list2.length){
                int sum = list1[l1] + list2[l2];
                pair.offer(new int[]{sum, list1[l1], list2[l2]});
                l2++;
            }
            l1++;
        }
        while(!pair.isEmpty() && target > 0){
            int[] pairComb = pair.poll();
            List<Integer> p = new ArrayList<>();
            p.add(pairComb[1]);
            p.add(pairComb[2]);
            pairs.add(p);
            target--;
        }
        
        return pairs;
    }
}
