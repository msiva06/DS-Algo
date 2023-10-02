package TwoHeaps;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Schedule Tasks on Minimum machines
public class Problem_02 {
    public static int tasks(List<List<Integer>> tasksList) {

    PriorityQueue<Integer> minEndTimeHeap = new PriorityQueue<Integer>((a,b) -> a - b);
    Collections.sort(tasksList,(a,b) -> a.get(0) - b.get(0));
    minEndTimeHeap.add(tasksList.get(0).get(1));
    for(int i = 1; i < tasksList.size(); i++){
      if(tasksList.get(i).get(0) >= minEndTimeHeap.peek()){
        minEndTimeHeap.poll();
      }
      minEndTimeHeap.offer(tasksList.get(i).get(1));
    }
    return minEndTimeHeap.size();
  }
}
