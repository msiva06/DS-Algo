// Isomorphic strings
public class Problem_04 {
    public static boolean isIsomorphic(String string1, String string2) {
        Map<Character,Character> map1map2 = new HashMap<>();
        Map<Character,Character> map2map1 = new HashMap<>();
        if(string1.length() != string2.length())
            return false;
        for(int i = 0; i < string1.length(); i++){
            char c1 = string1.charAt(i);
            char c2 = string2.charAt(i);
            if(!map1map2.containsKey(c1) && !map2map1.containsKey(c2)){
                map1map2.put(c1,c2);
                map2map1.put(c2,c1);
            }
            else if(map1map2.containsKey(c1) && map1map2.get(c1) != c2)
                return false;
            else if(map2map1.containsKey(c2) && map2map1.get(c2) != c1)
                return false;
        }
        return true;
    }
}
