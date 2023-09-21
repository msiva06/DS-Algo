package SlidingWindow;

// Minimum Size Subarray sum
public class Problem_07 {
    public static int minSubArrayLen(int target, int[] nums) {
      
        int start =0, end =0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(end < nums.length){
           sum += nums[end];
           while(sum >= target){
              int len = end - start + 1;
              if(len < minLen)
                 minLen = len;
              sum -= nums[start];
              start+= 1;
           }
           end++;
        }
           
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
     }
}
