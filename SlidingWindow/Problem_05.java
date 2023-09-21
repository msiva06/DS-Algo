package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Minimum window substring
public class Problem_05 {
    public static String minWindow(String s, String t) {

        int start = 0, end = 0;
        int[] res = new int[2];
        Map<Character,Integer> freq = new HashMap<>();
        Map<Character,Integer> windowFreq = new HashMap<>();
        for(int i =0; i < t.length();i++){
            freq.put(t.charAt(i),freq.getOrDefault(t.charAt(i),0) + 1);
            windowFreq.put(t.charAt(i),0);
        }
        int current = 0;
        int required = windowFreq.size();
        int minLen = Integer.MAX_VALUE;
        String minString = "";
        while(end < s.length()){
            if(windowFreq.containsKey(s.charAt(end))){
                windowFreq.put(s.charAt(end),windowFreq.get(s.charAt(end)) +1);
                if(windowFreq.get(s.charAt(end)) == freq.get(s.charAt(end))){
                    current += 1;
                    while(current == required){
                        int len = end - start + 1;
                        if(len < minLen){
                            minLen = len;  
                            res[0] = start;
                            res[1] = end+1;   
                        }
                        char left = s.charAt(start);
                        if(t.indexOf(left) != -1){
                            windowFreq.put(left,windowFreq.get(left)-1);
                            if(windowFreq.get(left) < freq.get(left))
                                current--;
                        }
                        start+=1;
                    }
                    
                }
            }
            end++;
        }
        minString = s.substring(res[0],res[1]);
        return minString;
    }
}
