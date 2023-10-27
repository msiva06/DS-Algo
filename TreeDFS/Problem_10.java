// Validate Binary Search tree
public class Problem_10 {
    public static boolean validateBst (TreeNode<Integer> root) {
        int low = Integer.MIN_VALUE, high = Integer.MAX_VALUE;
        return validBst(root,low,high);
    }

    public static boolean validBst(TreeNode<Integer> root, int low ,int high){
        if(root == null)
            return true;
        if((root.data <= low || root.data >= high))
            return false;
        return validBst(root.left,low,root.data) && validBst(root.right,root.data,high);
    }
}
