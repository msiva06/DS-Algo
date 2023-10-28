// Binary Tree Zigzag level order traversal
public class Problem_02 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
          return res;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
          List<Integer> sub = new ArrayList<Integer>();
          int size = queue.size();
          for(int i = 0; i < size; i++){
            TreeNode<Integer> node = queue.poll();
            sub.add(node.data);
            if(node.left != null)
              queue.offer(node.left);
            if(node.right != null)
              queue.offer(node.right);
          }
          if(level % 2 != 0){
            Collections.reverse(sub);
          }
          res.add(sub);
          level++;
        }
        return res;
      }
}
