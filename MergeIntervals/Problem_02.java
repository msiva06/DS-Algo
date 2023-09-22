package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

// Insert Interval
public class Problem_02 {
    public static List <Interval> insertInterval(List <Interval> existingIntervals, Interval newInterval) {
    List <Interval> output = new ArrayList <Interval> ();
    int i = 0;
    while(i < existingIntervals.size() && existingIntervals.get(i).getStart() <=
     newInterval.getStart()){
       output.add(new Interval(existingIntervals.get(i).getStart(),
       existingIntervals.get(i).getEnd()));
       i++;
     }

     if(newInterval.getStart() <= output.get(output.size()-1).getEnd()){
       output.set(output.size()-1, new Interval(output.get(output.size()-1).getStart(),
       Math.max(output.get(output.size()-1).getEnd(), newInterval.getEnd())));
     }
     else
     {
       output.add(new Interval(newInterval.getStart(),newInterval.getEnd()));
     }
     
     while(i < existingIntervals.size()){
       if(existingIntervals.get(i).getStart() <= output.get(output.size()-1).getEnd()){
         output.set(output.size()-1,new Interval(output.get(output.size()-1).getStart(),
          Math.max(output.get(output.size()-1).getEnd(),existingIntervals.get(i).getEnd())));
       }
       else{
         output.add(new Interval(existingIntervals.get(i).getStart(),
         existingIntervals.get(i).getEnd()));
       }
       i++;
     }
    return output;
  }
}
