// Palindrome permutations
public class Problem_01 {
    public static boolean permutePalindrome(String st) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : st.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int count = 0;
        for(Character k : map.keySet()){
            if(map.get(k) % 2 != 0)
                count++;
        }
        return count > 1 ? false : true;
    }
}
