// Next Greater Element
public class Problem_03 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
      
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
              while(!stack.isEmpty() && stack.peek() < nums2[i]){
                 int smallNum = stack.pop();
                 map.put(smallNum,nums2[i]);
              }
              stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
           int num = stack.pop();
           map.put(num,-1);
        }
        for(int i =0; i < nums1.length; i++){
           ans[i] = map.get(nums1[i]);
        }
        return ans;
     }
}