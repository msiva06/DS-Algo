package MergeIntervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Meeting Rooms II
public class Problem_06 {
    public static int minMeetingRooms(List <Interval> intervals) {

        if(intervals.size() == 0)   
            return 0;

        Collections.sort(intervals,(a,b)-> a.getStart() - b.getStart());
        PriorityQueue<Integer> meetingRooms = new PriorityQueue<>((a,b)-> a-b);
        meetingRooms.add(intervals.get(0).getEnd());
        for(int i = 1; i < intervals.size() ; i++){
            if(intervals.get(i).getStart() >= meetingRooms.peek()){
                meetingRooms.poll();
            }
            meetingRooms.add(intervals.get(i).getEnd());
        }
        
        return meetingRooms.size();
    }
}
