// Longest palindrome by concatenating two-letter words
public class Problem_08 {
    public static int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int count = 0;
        boolean central = false;
        for(String word: map.keySet()){
            Integer freq = map.get(word);
            if(word.charAt(0) == word.charAt(1)){
                if(freq % 2 == 0){
                    count += freq;
                }
                else{
                    count += freq-1;
                    central = true;
                }
            }
            else{
                if(word.charAt(1) > word.charAt(0) && map.containsKey(word.charAt(1)+""+word.charAt(0))){
                    count += 2 * Math.min(map.get(word),map.get(word.charAt(1)+""+word.charAt(0)));
                }
            }
        }
        if(central)
            count += 1;
        return count * 2;
        
    }
}
