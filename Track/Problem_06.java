// First Unique Character in a string
public class Problem_06 {
    public static int firstUniqueChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == 1)
            {
                return i;
            }
        }
        return -1;
     }
}
