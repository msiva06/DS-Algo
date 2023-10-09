package Greedy;

import java.util.PriorityQueue;

// Min number of refueling stops
public class Problem_05 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target)
            return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int stops = 0;
        int i = 0;
        while(startFuel < target){
            if(i < stations.length && startFuel >= stations[i][0]){
                maxHeap.add(stations[i][1]);
                i++;
            }
            else if(maxHeap.isEmpty())
            {
                return -1;
            }
            else{
                stops += 1;
                startFuel += maxHeap.poll();
            }
        }
        
        return stops;
    }
}
