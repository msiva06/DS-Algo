package SlidingWindow;

// Max Consecutive ones III
public class Problem_10 {
    public int longestOnes(int[] nums, int k) {
        int onesCount = 0;
        int start = 0, end = 0;
        int maxOnes = Integer.MIN_VALUE;
        while(end < nums.length){
            if(nums[end] == 1)
                onesCount++;
           
            if(end - start + 1 - onesCount > k){
                if(nums[start] == 1)
                    onesCount--;
                start++;
            } 
            maxOnes = Math.max(maxOnes,end-start+1);
            end++;
        }
        return maxOnes;
    }
}
