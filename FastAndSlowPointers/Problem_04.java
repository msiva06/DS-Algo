package FastAndSlowPointers;

//Circular Array loop
public class Problem_04 {
    public static boolean circularArrayLoop(int[] nums) {
      
        for(int i = 0; i < nums.length; i++){
           int slow = i;
           int fast = i;
           boolean forward = nums[i] >= 0;
           while(true){
              slow = nextStep(slow,nums);
              if(isNotCyle(slow,forward,nums))
                 break;
              fast = nextStep(fast,nums);
              if(isNotCyle(fast,forward,nums))
                 break;
              fast = nextStep(fast,nums);
              if(isNotCyle(fast,forward,nums))
                 break;
              if(slow == fast)
                 return true;
           }
        }
        return false;
     }
  
     public static int nextStep(int currIdx,int[] nums){
        int result = (currIdx + nums[currIdx]) % nums.length;
        if(result < 0){
           result += nums.length;
        }
        return result;
     }
  
     public static boolean isNotCyle(int currIdx,boolean prevDir,int[] nums){
        boolean currDir = nums[currIdx] >= 0;
        if(currDir != prevDir || Math.abs(nums[currIdx]) % nums.length == 0)
           return true;
        return false;
     }
}
