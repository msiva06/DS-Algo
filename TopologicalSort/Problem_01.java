package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Compilation order
public class Problem_01 {
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
      List<Character> sortedOrder = new ArrayList<Character>();
      Map<Character,List<Character>> graph = new HashMap<Character,List<Character>>();
      Map<Character,Integer> inDegree = new HashMap<Character,Integer>();
      for(int i = 0; i < dependencies.size(); i++){
          Character parent = dependencies.get(i).get(1);
          Character child = dependencies.get(i).get(0);
          if(!graph.containsKey(parent))
          {
            List<Character> newList = new ArrayList<>();
            newList.add(child);
            graph.put(parent, newList);
          }     
          else
          {
              List<Character> existingList = graph.get(parent);
              existingList.add(child);
              graph.put(parent,existingList);
          }
          graph.put(child,graph.getOrDefault(child, new ArrayList<>()));
          inDegree.put(parent,inDegree.getOrDefault(parent,0));
          inDegree.put(child,inDegree.getOrDefault(child,0) + 1);
      }
      if(graph.size() <= 0)
        return sortedOrder;
      Queue<Character> sources = new LinkedList<Character>();
      for(char key:inDegree.keySet()){
          if(inDegree.get(key) == 0){
              sources.add(key);
          }
      }
      while(!sources.isEmpty()){
          char vertex = sources.poll();
          sortedOrder.add(vertex);
          if(graph.containsKey(vertex)){
              List<Character> childList = graph.get(vertex);
              for(Character child:childList){
                  inDegree.put(child,inDegree.get(child)-1);
                  if(inDegree.get(child) == 0)
                    sources.add(child);
              }
          }
      }
      if(sortedOrder.size() != graph.size())
        return new ArrayList<>();
      return sortedOrder;
    }
}
