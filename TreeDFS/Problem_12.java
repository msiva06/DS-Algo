// Kth smallest elem in BST
public class Problem_12 {
    public static int kthSmallestElement(TreeNode<Integer> root, int k) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = root;
        while(curr != null || !stack.isEmpty()){
          while(curr != null){
            stack.push(curr);
            curr = curr.left;
          }
          curr = stack.pop();
          k--;
          if(k == 0)
            return curr.data;
          curr = curr.right;
        }
        return -1;
    }
}
