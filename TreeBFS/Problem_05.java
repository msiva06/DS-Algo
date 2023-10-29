// Symmetric tree
public class Problem_05 {
    public static boolean isSymmetric(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
          int size = queue.size();
          List<Integer> lList = new ArrayList<>();
          for(int i = 0; i < size; i++){
            TreeNode<Integer> node = queue.poll();
            if(node.left != null){
              queue.offer(node.left);
              
            }
            if(node.right != null){
              queue.offer(node.right);
              
            }
            lList.add(node.left == null ? null : node.left.data);
            lList.add(node.right == null ? null : node.right.data);
          }
            lList.stream().forEach(System.out::println);
            int start = 0, end = lList.size()-1;
            while(start < end){
              if(lList.get(start) != lList.get(end))
                return false;
              start++;
              end--;
            }
        }
        return true;
      }
}
