package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Course Schedule II
public class Problem_02 {
    public static List <Integer> findOrder(int n, int[][] prerequisites) {
      Map<Integer,Integer> inDegree = new HashMap<Integer,Integer>();
      Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
      for(int i = 0; i < n;i++){
        inDegree.put(i,0);
        graph.put(i, new ArrayList<>());
      }
      for(int i = 0; i < prerequisites.length; i++){
        int parent = prerequisites[i][1];
        int child = prerequisites[i][0];
        List<Integer> existingList = graph.get(parent);
        existingList.add(child);
        graph.put(parent,existingList);
        inDegree.put(child,inDegree.getOrDefault(child,0)+1);
      }
      List<Integer> res = new ArrayList<Integer>();
      Queue<Integer> sources = new LinkedList<Integer>();
      for(Integer i : inDegree.keySet()){
        if(inDegree.get(i) == 0)
          sources.add(i);
      }
      while(!sources.isEmpty()){
        int src = sources.poll();
        res.add(src);
        if(!graph.get(src).isEmpty()){
          List<Integer> existingList = graph.get(src);
          for(Integer i : existingList){
            inDegree.put(i, inDegree.get(i)-1);
            if(inDegree.get(i) == 0)
              sources.add(i);
          }
        }
      }
      if(res.size() < n)
        return new ArrayList<>();
      return res;
    }
}
