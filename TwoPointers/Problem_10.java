package TwoPointers;

import java.util.Arrays;

// Max number of K-sum pairs
public class Problem_10 {
    public int maxOperations(int[] nums, int k) {
        int start =0, end = nums.length-1;
        Arrays.sort(nums);
        int totalOperations = 0;
        while(start < end){
            int currSum = nums[start] + nums[end];
            if(currSum == k){
                totalOperations++;
                start++;
                end--;
            }
            else if(currSum < k)
                start++;
            else
                end--;
            
        }
        return totalOperations;
    }
}
