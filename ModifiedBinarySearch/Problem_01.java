package ModifiedBinarySearch;

// Binary Search
public class Problem_01 {
    public static int binarySearch (int []nums, int target) {
        
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target < nums[mid]){
                right = mid-1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target == nums[mid]){
                return mid;
            }
        }
        return -1;
    }
}
