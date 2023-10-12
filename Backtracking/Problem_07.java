package Backtracking;

import java.util.Arrays;
import java.util.Collections;

// MatchSticks to square
public class Problem_07 {
    public static boolean matchstickToSquare(int[] nums) {
      
      nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
      int maxSquareLen = nums[0];
      int left = 0, right = nums.length-1;
      int target = 4;
      System.out.println(maxSquareLen);
      while(left <= right && target > 0){
         if(nums[left] == maxSquareLen){
            target--;
            left++;
         }
         else if(nums[left] + nums[right] == maxSquareLen){
            target--;
            left++;
            right--;
         }
         else{
            return false;
         }
      }
      return target > 0 ? false : true;
   }
}
