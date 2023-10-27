// Binary tree max path sum
public class Problem_05 {
    public static int maxPathSum(TreeNode<Integer> root) {
        int[] sum = new int[1];
        maxSum(root,sum);
        return sum[0];
      }
    
      public static int maxSum(TreeNode<Integer> root,int[] sum){
        if(root == null){
          return 0;
        }
        int lSum = Math.max(maxSum(root.left,sum), 0);
        int rSum = Math.max(maxSum(root.right,sum),0);
        sum[0] = Math.max(sum[0], lSum + rSum + root.data);
        return root.data + Math.max(lSum,rSum);
    
      }
}
