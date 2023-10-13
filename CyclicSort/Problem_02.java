package CyclicSort;

import java.util.Arrays;

// First Missing Positive
public class Problem_02 {
    public static int firstMissingPositiveInteger(int[] nums) {

      int n = nums.length;
      int ind = 0;
      while(ind < n){
         int value = nums[ind]-1;
         if(ind != value && value >= 0 && value < n){
            int temp = value;
            nums[ind] = nums[temp];
            nums[temp] = value+1;
         }
         else{
            ind++;
         }
      }
      Arrays.stream(nums).forEach(System.out::println);
      for(int i = 0; i < n; i++){
         if(i + 1 != nums[i]){
            return i + 1;
         }
      }
      return n + 1;
   }
}
