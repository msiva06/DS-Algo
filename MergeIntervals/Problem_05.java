package MergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Task scheduler
public class Problem_05 {
    public static int leastTime(char[] tasks, int n) {
    
    Map<Character,Integer> freq = new HashMap<>();
    for(char c : tasks){
      freq.put(c,freq.getOrDefault(c,0)+1);
    }
    List<Integer> taskList = new ArrayList<>(freq.values());
    taskList.sort(Comparator.naturalOrder());

    int maxFreq = taskList.get(taskList.size()-1);
    taskList.remove(taskList.size()-1);
    int idleTime = (maxFreq - 1) * n;
    while(!taskList.isEmpty() && idleTime > 0){
      idleTime -= Math.min(maxFreq-1,taskList.get(taskList.size()-1));
      taskList.remove(taskList.size()-1);
    }
    idleTime = Math.max(0,idleTime);
    int tasktime = tasks.length + idleTime;
    return tasktime;
  }
}
