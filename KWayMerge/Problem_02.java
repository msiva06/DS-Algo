package KWayMerge;

import java.util.List;
import java.util.PriorityQueue;

// Kth smallest number in M Sorted Lists
public class Problem_02 {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

   PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
   for(int i = 0; i < lists.size(); i++){
     for(int j = 0; j < lists.get(i).size(); j++){
       minHeap.add(lists.get(i).get(j));
     } 
   }  
   int kthElem = 0;
   while(!minHeap.isEmpty() && k > 0){
     kthElem = minHeap.poll();
     k--;
   }  
  return kthElem;
  }
}
