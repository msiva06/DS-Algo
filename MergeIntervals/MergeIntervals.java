package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

// Merge Intervals
public class MergeIntervals {
    public static List <Interval> mergeIntervals(List <Interval> intervals) {
    List<Interval> mergeIntervals = new ArrayList<Interval>();
    mergeIntervals.add(new Interval(intervals.get(0).getStart(),
    intervals.get(0).getEnd()));
    int j = 0;
    for(int i = 1; i < intervals.size(); i++){
      if(intervals.get(i).getStart() <= mergeIntervals.get(j).getEnd()){
        int start = mergeIntervals.get(j).getStart();
        int end = Math.max(intervals.get(i).getEnd(), mergeIntervals.get(j).getEnd());
        mergeIntervals.set(j, new Interval(start,end));
      }
      else{
        mergeIntervals.add(new Interval(intervals.get(i).getStart(),
        intervals.get(i).getEnd()));
        j++;
      }
    }
    return mergeIntervals;
  }
}
