package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// Network Delay Time
public class Problem_01 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adjList = new HashMap<Integer,List<int[]>>();
        int delay = 0;
        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int source = times[i][0];
            int dest = times[i][1];
            int time = times[i][2];
            List<int[]> existingList = adjList.get(source);
            existingList.add(new int[]{time,dest});
            adjList.put(source,existingList);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,k});
        Set<Integer> visited = new HashSet<Integer>();
        while(!pq.isEmpty()){
            int[] pop = pq.poll();
            int time = pop[0];
            int node = pop[1];
            if(visited.contains(node))
                continue;
            visited.add(node);
            delay = Math.max(delay,time);
            List<int[]> neighbors = adjList.get(node);
            for(int[] nei: neighbors){
                int nTime = nei[0];
                int nNode = nei[1];
                if(!visited.contains(nNode)){
                    int newTime = time + nTime;
                    pq.add(new int[]{newTime,nNode});
                }
            }
        }
        if(visited.size() == n)
            return delay;
        return -1;
    }
}
