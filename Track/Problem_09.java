// Ransom note
public class Problem_09 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char c : magazine.toCharArray()){
            if(map.containsKey(c)){
                if(map.get(c) == 1){
                    map.remove(c);
                }
                else{
                    map.put(c,map.get(c)-1);
                }
            }
        }
        return map.size() == 0;
        
    }
}
