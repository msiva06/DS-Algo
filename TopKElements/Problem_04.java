package TopKElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Top k frequent words
public class Problem_04 {
    public static List<String> topKFrequent(String[] arr, int k) {

        List<String> res = new ArrayList<String>();
        Map<String,Integer> freq = new HashMap<String,Integer>();
        for(String s : arr){
            freq.put(s, freq.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) ->
            a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for(Map.Entry<String,Integer> freqIter : freq.entrySet()){
            pq.add(freqIter);
            if(pq.size() > k)
                pq.poll();
        }
        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
