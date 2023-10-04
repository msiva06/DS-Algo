package TopKElements;

import java.util.PriorityQueue;

// Kth largest element in array
public class Problem_03 {
    public static int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> a - b);
      for(int i = 0; i < k; i++){
         pq.add(nums[i]);
      }
      int res = 0;
      int i = k;
      while(!pq.isEmpty() && i < nums.length){
         if(nums[i] > pq.peek()){
            pq.poll();
            pq.add(nums[i]);
         }
         i++;
      }
      return pq.peek();
     
   }
}
