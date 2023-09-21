package SlidingWindow;

// Max number of vowels in a substring of given length
public class Problem_09 {
    public int maxVowels(String s, int k) {
        int left = 0, right = 0;
        int maxVowelCount = Integer.MIN_VALUE;
        int vowelCount = 0;
        for(int i = 0; i < k; i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                vowelCount++;
            }
        }
        maxVowelCount = Math.max(maxVowelCount, vowelCount);
        right = k;
        while(right < s.length()){

            if(s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o' || s.charAt(left) == 'u'){
                vowelCount--;
            }
            left++;
            if(s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i' || s.charAt(right) == 'o' || s.charAt(right) == 'u'){
                vowelCount++;
            }
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
            right++;
        }
        return maxVowelCount;
    }
}
