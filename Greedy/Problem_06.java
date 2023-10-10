package Greedy;

// Jump Game II
public class Problem_06 {
    public static int jumpGame2(int[] nums) {
        int steps = 0;
        int currEnd = 0, currFar = 0;
        for(int i =0; i < nums.length -1; i++){
           currFar = Math.max(currFar,i+nums[i]);
           if(i == currEnd){
              steps+=1;
              currEnd = currFar;
           }
        }
        return steps;
      }
}
