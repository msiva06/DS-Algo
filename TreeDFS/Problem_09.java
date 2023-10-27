//Lowest common Ancestor of binary tree
public class Problem_09 {
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode<Integer> left = lowestCommonAncestor(root.left,p,q);
        TreeNode<Integer> right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
