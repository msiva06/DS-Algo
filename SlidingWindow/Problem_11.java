package SlidingWindow;

// Longest Subarray of 1's after deleting one element
public class Problem_11 {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int start = 0,end = 0; 
        int maxCount = Integer.MIN_VALUE;
        while(end < nums.length){
            if(nums[end] == 0)
                zeroCount++;
            while(zeroCount > 1){
                if(nums[start] == 0)
                    zeroCount--;
                start++;
            }
            maxCount = Math.max(maxCount,end-start);
            end++;
        }
        return maxCount;
    }
}
