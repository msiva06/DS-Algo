package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Paths in Maze that lead to same room
public class Problem_02 {
    public static int numberOfPaths(int n, int[][] corridors) {
        Map<Integer,Set<Integer>> adjList = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adjList.put(i,new HashSet<>());
        }
        int cycle = 0;
        for(int i = 0; i < corridors.length; i++){
            int node1 = corridors[i][0];
            int node2 = corridors[i][1];
            Set<Integer> node1HashSet = adjList.get(node1);
            node1HashSet.add(node2);
            adjList.put(node1,node1HashSet);
            Set<Integer> node2HashSet = adjList.get(node2);
            node2HashSet.add(node1);
            adjList.put(node2,node2HashSet);
            cycle += getIntersectionCycle(node1HashSet,node2HashSet);
        }
        return cycle;
    }

    public static int getIntersectionCycle(Set<Integer> set1, Set<Integer> set2){
        int count = 0;
        for(Integer s : set1){
            if(set2.contains(s))
                count++;
        }
        return count;
    }
}
