package TwoPointers;

// Is Subsequence
public class Problem_07 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int tStart = 0, sStart = 0;
        while(sLength > 0 && tLength > 0 && tStart < tLength && sStart < sLength){
            if(t.charAt(tStart) == s.charAt(sStart)){
                sStart++;
            }
            tStart++;
        }
        return (sStart == sLength);
    }
}
