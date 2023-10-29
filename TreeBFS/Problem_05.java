// Symmetric tree
public class Problem_05 {
    public static boolean isSymmetric(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
    // queue.offer(root);
    // while(!queue.isEmpty()){
    //   int size = queue.size();
    //   List<Integer> lList = new ArrayList<>();
    //   for(int i = 0; i < size; i++){
    //     TreeNode<Integer> node = queue.poll();
    //     if(node.left != null){
    //       queue.offer(node.left); 
    //     }
    //     if(node.right != null){
    //       queue.offer(node.right);  
    //     }
    //     lList.add(node.left == null ? null : node.left.data);
    //     lList.add(node.right == null ? null : node.right.data);
    //   }
    //     int start = 0, end = lList.size()-1;
    //     while(start < end){
    //       if(lList.get(start) != lList.get(end))
    //         return false;
    //       start++;
    //       end--;
    //     }
    // }
    // return true;
    queue.offer(root.left);
    queue.offer(root.right);
    while(!queue.isEmpty()){
      TreeNode<Integer> left = queue.poll();
      TreeNode<Integer> right = queue.poll();
      if(left == null && right == null)
        continue;
      if(left == null || right == null)
        return false;
      if(left.data != right.data)
        return false;
      queue.offer(left.left);
      queue.offer(right.right);
      queue.offer(left.right);
      queue.offer(right.left);
    }
    return true;
      }
}
