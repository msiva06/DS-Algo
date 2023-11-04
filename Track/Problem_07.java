// Find all anagrams in string
public class Problem_07 {
    public static List<Integer> findAnagrams(String a, String b) {
        List<Integer> res = new ArrayList<>();
        if(a.length() < b.length())
         return res;
        Map<Character,Integer> hashA = new HashMap<>();
        Map<Character,Integer> hashB = new HashMap<>();
        for(int i = 0; i < b.length(); i++){
            char c = b.charAt(i);
            hashB.put(c, hashB.getOrDefault(c,0)+1);
        }
        int end = 0;
        while(end < a.length()){
            char aChar = a.charAt(end);
            hashA.put(aChar,hashA.getOrDefault(aChar,0)+1);
            for(char c : hashA.keySet()){
                System.out.println(c + " " + hashA.get(c));
            }
            System.out.print("*************");
            int start = end - b.length();
            if(end >= b.length()){
                char aStart = a.charAt(start);
                if(hashA.containsKey(aStart)){
                    if(hashA.get(aStart) == 1)
                     hashA.remove(aStart);
                    else
                     hashA.put(aStart,hashA.get(aStart)-1);
                }
            }
            
             if(hashA.equals(hashB))
             {
                 res.add(start+1);
             }
            end++;
        }
        return res;
     }
}
