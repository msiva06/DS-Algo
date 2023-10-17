package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Find all possible recipes from given supplies
public class Problem_04 {
    public static List<String> findAllRecipes (String[] recipes, List<List<String>> ingredients, String[] supplies) {
       Map<String,Integer> count = new HashMap<String,Integer>();
       Map<String,List<String>> graph = new HashMap<>();
       for(int i = 0; i < recipes.length; i++){
        count.put(recipes[i],ingredients.get(i).size());
        for(String ing : ingredients.get(i)){
          if(graph.containsKey(ing)){
            List<String> existingList = graph.get(ing);
            existingList.add(recipes[i]);
            graph.put(ing,existingList);
          }
          else{
            List<String> newList = new ArrayList<>();
            newList.add(recipes[i]);
            graph.put(ing,newList);
          }
        }

       }
       List<String> ans = new ArrayList<String>();
       Queue<String> q = new LinkedList<>();
       for(int i = 0; i < supplies.length; i++){
        q.add(supplies[i]);
       }
       while(!q.isEmpty()){
        String sup = q.poll();
        if(graph.containsKey(sup)){
          List<String> recpes = graph.get(sup);
          for(String recipe : recpes){
            count.put(recipe,count.get(recipe)-1);
            if(count.get(recipe) == 0){
               ans.add(recipe);
               q.add(recipe);
            } 
          }
        }
       }
       return ans;
    }
}
