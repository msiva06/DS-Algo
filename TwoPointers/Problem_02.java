package TwoPointers;

import java.util.Arrays;

// Sum of three values
public class Problem_02 {
 
    public static boolean findSumOfThree(int[] nums, int target) {
      
      Arrays.sort(nums);
        int numLength = nums.length;

        for(int i = 0; i < numLength; i++){
            int low = i+1, high = numLength-1;
            int sum = target - nums[i];
            while(low < high){
                int innerSum = nums[low] + nums[high];
                if(innerSum > sum){
                    high--;
                }
                else if(innerSum < sum){
                    low++;
                }
                else 
                    return true;

            }
        }
        return false;
   }
}
