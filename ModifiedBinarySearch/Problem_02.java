package ModifiedBinarySearch;

import java.util.List;

// Search in rotated sorted array
public class Problem_02 {
    public static int binarySearchRotated(List<Integer> nums, int target) {
      
      int low = 0, high = nums.size() -1;
      while(low <= high){
         int mid = low + (high - low)/2;
         if(target == nums.get(mid))
            return mid;

         else if(nums.get(low) <= nums.get(mid)){
            if(nums.get(low) <= target && nums.get(mid) > target)
               high = mid-1;
            else
               low = mid + 1;
         }
         else
         {
            if(nums.get(mid) <= target && nums.get(high) > target)
               low = mid + 1;
            else  
               high = mid - 1;
         }
      }
      
      return -1;
   }
}
