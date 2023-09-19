package FastAndSlowPointers;

// Find the Duplicate Number
public class Problem_05 {
    public static int findDuplicate(int[] nums) {
      
        // Replace this placeholder return statement with your code
        int slow = nums[0], fast = nums[0];
        while(true){
           slow = nums[slow];
           fast = nums[nums[fast]];
           if(slow == fast)
              break;
        }
        slow = nums[0];
        while(slow != fast){
           slow = nums[slow];
           fast = nums[fast];
        }
        return slow;
     }
}
