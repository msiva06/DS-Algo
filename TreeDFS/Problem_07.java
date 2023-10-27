// Binary Tree Right Side view
public class Problem_07 {
    public static List<Integer> rightSideView(TreeNode<Integer> root) {

        List<Integer> rightViewList = new ArrayList<>();
        if(root == null)
            return rightViewList;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            for(int i = 0; i < size; i++){
                TreeNode<Integer> d = queue.poll();
                System.out.println(d);
                if(i+1 == size){
                    rightViewList.add(d.data);
                }
                if(d.left != null)
                    queue.offer(d.left);
                if(d.right != null)
                    queue.offer(d.right);
            }
        }
        return rightViewList;
    }
}
