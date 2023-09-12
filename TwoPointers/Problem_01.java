package TwoPointers;

// Valid Palindrome
public class Problem_01 {
    public static boolean isPalindrome(String s) {
       
        int strLength = s.length();
        int start =0, end = strLength-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
}
