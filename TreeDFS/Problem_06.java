//Sorted Array to BST
public class Problem_06 {
    public static TreeNode<Integer> sortedArrayToBST(int[] nums) {

        return generateBST(nums,0,nums.length-1);
     }
 
     public static TreeNode<Integer> generateBST(int[] nums,int start,int end){
         if(start  > end)
             return null;
         int mid = start + (end - start)/2;
         TreeNode<Integer> root = new TreeNode<>(nums[mid]);
         root.left = generateBST(nums,start,mid-1);
         root.right = generateBST(nums,mid+1,end);
         return root;
     }
}
