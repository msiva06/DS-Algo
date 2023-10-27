// Maximum depth of binary tree
public class Problem_11 {
    public static int findMaxDepth(TreeNode<Integer> root) {
        return depth(root,0);
    }
    public static int depth(TreeNode<Integer> root, int dep){
      if(root == null){
        return 0;
      }
      return 1 + Math.max(depth(root.left,dep+1),depth(root.right,dep+1));
    }
}
