package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.List;

// Find K Closest elements
public class Problem_03 {
    public static List<Integer> findClosestElements(int[] nums, int k, int target) {
      List<Integer> res = new ArrayList<Integer>();
      if(nums.length == k){
         for(int num:nums)
            res.add(num);
         return res;
      }
      int firstClosest = binarySearch(nums,target);
      int start = firstClosest-1;
      int end = firstClosest+1;
      while(end - start - 1 < k){
         if(start == -1)
         {
            end++;
            continue;
         }
         if(end == nums.length || Math.abs(nums[start] - target) <= 
            Math.abs(nums[end] - target)){
               start--;
         }
         else
            end++;
      }
      for(int i = start+1; i < end; i++)
         res.add(nums[i]);
      return res;
   }

   public static int binarySearch(int[] nums,int target){
      int left = 0, right = nums.length -1;
      while(left < right){
         int mid = left + (right - left)/2;
         if(nums[mid] == target)
            return mid;
         else if(target < nums[mid]){
            right = mid - 1;
         }
         else{
            left = mid + 1;
         }
      }
      return left;
   }
}
