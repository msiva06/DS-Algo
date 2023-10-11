package Backtracking;


// House Robber III
public class Problem_03 {
    public static int rob(TreeNode<Integer> root) {
      int[] heistVal = heist(root);
      return Math.max(heistVal[0],heistVal[1]);
    }

    public static int[] heist(TreeNode<Integer> root){
      if(root == null)
        return new int[]{0,0};
      int[] left = heist(root.left);
      int[] right = heist(root.right);
      int include = root.data + left[1] + right[1];
      int exclude = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
      return new int[]{include,exclude};
    }
}
