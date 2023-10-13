package CyclicSort;

// Find corrupt pair
public class Problem_03 {
    public static int[] findCorruptPair(int[] nums) {
        int n = nums.length;
        int ind = 0;
        int[] pair = new int[2];
        while(ind < n){
           int value = nums[ind]-1;
           if(nums[ind] != nums[value]){
              int temp = nums[ind];
              nums[ind] = nums[value];
              nums[value] = temp;
           }
           else{
              ind++;
           }
        }
        for(int i = 0; i < n; i++){
           if(i + 1 != nums[i]){
              pair[0] = i+1;
              pair[1] = nums[i];
           }
        }
        return pair;
     }
}
