// Flatten Binary Tree to LinkedList
public class Problem_01 {
    public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {
		if(root == null)
			return null;
		TreeNode<Integer> curr = root;
		while(curr != null){
			if(curr.left != null){
				TreeNode<Integer> last = curr.left;
				while(last != null && last.right != null){
					last = last.right;
				}
				last.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
		return root;
	}
}
