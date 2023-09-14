package TwoPointers;

// Move Zeroes to End
public class Problem_08 {
    public void moveZeroes(int[] nums) {
        int nonZeroStart = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroStart++] = nums[i];
            }
        }
        System.out.println(nonZeroStart);
        for(int i = nonZeroStart; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
