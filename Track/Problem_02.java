// Valid Anagram
public class Problem_02 {
    public static boolean isAnagram(String str1, String str2) {
        int[] s1 = new int[26];
        for(char c : str1.toCharArray()){
            int idx = c - 'a';
            s1[idx] += 1;
        }
        for(char c : str2.toCharArray()){
            int idx = c - 'a';
            s1[idx] -= 1;
        }
        for(int s : s1){
            if(s != 0)
              return false;
        }
        return true;
      }
}
