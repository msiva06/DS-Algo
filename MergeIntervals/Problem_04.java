package MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Employee free time
public class Problem_04 {
    public static List <Interval> employeeFreeTime(ArrayList <ArrayList <Interval>> schedule) {


    List<Interval> ans = new ArrayList<Interval>();
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    for(int i = 0; i < schedule.size();i++){
      List<Interval> empSchedule = schedule.get(i);
      minHeap.offer(new int[]{empSchedule.get(0).getStart(),i,0});
    }
    int previous = schedule.get(minHeap.peek()[1]).get(minHeap.peek()[2]).getStart();
    while(!minHeap.isEmpty()){
      int[] tuple = minHeap.poll();
      int i = tuple[1];
      int j = tuple[2];
      Interval next = schedule.get(i).get(j);
      if(next.getStart() > previous){
        ans.add(new Interval(previous,next.getStart()));
      }
      previous = Math.max(previous,next.getEnd());
      if(j+1 < schedule.get(i).size()){
        minHeap.offer(new int[]{schedule.get(i).get(j+1).getStart(),i,j+1});
      }
    }
    return ans;
  }
}
