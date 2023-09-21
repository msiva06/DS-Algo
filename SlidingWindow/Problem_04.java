package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Longest Repeating Character Replacement
public class Problem_04 {
    public static int longestRepeatingCharacterReplacement(String s, int k) {
    Map<Character,Integer> freq = new HashMap<>();
    int lengthOfString = 0;
    int mostFreqChar = 0;
    int start = 0;
    for(int end = 0; end < s.length(); end++){
        freq.put(s.charAt(end),freq.getOrDefault(s.charAt(end),0)+1);
        mostFreqChar = Math.max(mostFreqChar,freq.get(s.charAt(end)));
        if(end - start + 1 - mostFreqChar > k){
            freq.put(s.charAt(start),freq.get(s.charAt(start))-1);
            start += 1;
        } 
        lengthOfString = Math.max(lengthOfString,end-start+1);
    }
    return lengthOfString;
  }
}
