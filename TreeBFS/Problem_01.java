// Level order traversal of binary tree
public class Problem_01 {
    public static String levelOrderTraversal(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        if(root == null)
         return "None";
        queue.offer(root);
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
           int size = queue.size();
           StringBuilder sb = new StringBuilder();
           for(int i = 0; i < size;i++){
             TreeNode<Integer> node = queue.poll();
             sb.append(node.data);
             if(i != size-1)
               sb.append(", ");
             if(node.left != null)
               queue.offer(node.left);
             if(node.right != null)
               queue.offer(node.right);
           }
           res.append(sb);
           res.append(" : ");
        }
        res.delete(res.length()-3,res.length());
        return new String(res);
     }
}
