package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Longest substring without repeating characters
public class Problem_06 {
    public static int findLongestSubstring(String str) {

        Map<Character,Integer> indexCharMap = new HashMap<>();
        int start = 0, end = 0;
        int longestLen = 0;
        while(end < str.length()){
            if(!indexCharMap.containsKey(str.charAt(end))){
                indexCharMap.put(str.charAt(end),end);
            }
            else{
                int prevIndex = indexCharMap.get(str.charAt(end));
                if(prevIndex >= start && prevIndex <= end){
                    start = prevIndex + 1;
                }
                indexCharMap.replace(str.charAt(end),end);
            }
            longestLen = Math.max(longestLen,end - start+1);
            end++;
        }

        return longestLen;
    }
}
