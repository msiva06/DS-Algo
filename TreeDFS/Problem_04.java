// Invert Binary Tree
public class Problem_04 {
    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){
       
        if(root == null)  
          return null;
        if(root.left != null){
          invertTree(root.left);
        }
        if(root.right != null){
          invertTree(root.right);
        }
        TreeNode<Integer> temp = root.left;
        root.left= root.right;
        root.right = temp;
        return root;
    }
}
