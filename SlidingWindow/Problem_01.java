package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

// Repeated DNA Sequence
public class Problem_01 {
    public static Set<String> findRepeatedSequences(String s, int k) {
    
    Set<String> repeated = new HashSet<String>();
    Set<String> sequences = new HashSet<String>();
    for(int i = 0; i < s.length()-k; i++){
       String sequence = s.substring(i, i+k);
       if(!sequences.contains(sequence)){
          sequences.add(sequence);
       }
       else{
          repeated.add(sequence);
       }
    }
    
    return repeated;
   }
}
