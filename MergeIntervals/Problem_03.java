package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

// Interval List intersections
public class Problem_03 {
    public static List <Interval> intervalsIntersection(List <Interval> intervalLista, List <Interval> intervalListb) {
    List <Interval> intersections = new ArrayList <>();
    int intA = 0, intB = 0;
    while(intA < intervalLista.size() && intB < intervalListb.size()){
      int start = Math.max(intervalLista.get(intA).getStart(),
          intervalListb.get(intB).getStart());
      int end = Math.min(intervalLista.get(intA).getEnd(),
        intervalListb.get(intB).getEnd());

      if(start <= end){
        intersections.add(new Interval(start,end));
      }
      if(intervalLista.get(intA).getEnd() < intervalListb.get(intB).getEnd()){
        intA+= 1;
      }
      else {
        intB+= 1;
      }
    }

    return intersections;
  }
}
