// Group Anagrams
public class Problem_04 {
    public static List<List<String>> groupAnagrams(String[] strs){

        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
           int[] arr = new int[26];
           for(int i = 0; i < s.length(); i++){
               char c = s.charAt(i);
               int idx = c - 'a';
               arr[idx] += 1;
           } 
           StringBuilder sb = new StringBuilder();
           for(int a : arr){
               sb.append("#");
               sb.append(a);
           }
           String newStr = sb.toString();
           if(!map.containsKey(newStr))
             map.put(newStr, new ArrayList<>());
           map.get(newStr).add(s);
        }
        return new ArrayList<>(map.values());
     }
}
