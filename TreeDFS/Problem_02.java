// Diameter of binary Tree
public class Problem_02 {
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        if(root == null)
          return 0;
        int[] diam = new int[1];
        diameter(root,diam);
        return diam[0];
    }
    
    public static int diameter(TreeNode<Integer> root,int[] diam){
      if(root == null)
        return 0;
      int lheight = diameter(root.left,diam);
      int rheight = diameter(root.right,diam);
      diam[0] = Math.max(diam[0], lheight + rheight);
      return 1 + Math.max(lheight,rheight);
    }
}
