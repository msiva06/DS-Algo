// Longest Palindrome
public class Problem_05 {
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int length = 0;
        for(Map.Entry<Character,Integer> m : map.entrySet()){
                int pair = m.getValue()/2;
                System.out.println(pair);
                length += (pair * 2);
        }
        if(length+1 <=s.length())
            return length + 1;
        return length;
    } 
}
