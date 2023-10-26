package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Bus routes
public class Problem_05 {
    public static int minimumBuses(int[][] busRoutes, int src, int dest) {
        int buses = busRoutes.length;
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < buses; i++){
            for(int j = 0; j < busRoutes[i].length; j++){
                if(!adjList.containsKey(busRoutes[i][j])){
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(i);
                    adjList.put(busRoutes[i][j], newList);
                }
                else{
                    List<Integer> existingList = adjList.get(busRoutes[i][j]);
                    existingList.add(i);
                    adjList.put(busRoutes[i][j],existingList);
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.add(new int[]{src,0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int station = curr[0];
            int minBus = curr[1];
            if(station == dest)
                return minBus;
            List<Integer> busList = adjList.get(station);
            for(int bus : busList){
                if(visited.contains(bus))
                    continue;
                visited.add(bus);
                for(int j = 0; j < busRoutes[bus].length; j++){
                    queue.add(new int[]{busRoutes[bus][j], minBus + 1});
                }
            }
        }
        return -1;
    }
}
