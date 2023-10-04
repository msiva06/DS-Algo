package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Top K frequent elements
public class Problem_02 {
    public static List<Integer> topKFrequent(int[] arr, int k) {

    Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
    for(int a : arr)
        freq.put(a, freq.getOrDefault(a,0)+1);
    PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
    for(Map.Entry<Integer,Integer> freqMap : freq.entrySet()){
        pq.add(freqMap);
    }
    List<Integer> res = new ArrayList<Integer>();
    while(!pq.isEmpty() && k > 0){
        Integer val = pq.poll().getKey();
        res.add(val);
        k--;
    }

    return res;
    }
}
