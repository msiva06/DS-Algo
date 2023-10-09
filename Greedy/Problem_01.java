package Greedy;

// Jump Game I
public class Problem_01 {
    public static boolean jumpGame(int[] nums) {
        int targetIndex = nums.length -1;
        for(int i = nums.length-2; i >= 0; i--){
           if(targetIndex <= (i + nums[i]))
              targetIndex = i;
        }
        if(targetIndex == 0)
           return true;
        return false;
     }
}
