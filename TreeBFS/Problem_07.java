// Max Level sum of binary tree
public class Problem_07 {

    public int maxLevelSum(TreeNode root) {
        int maxLevel = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1,sum = root.val;
        while(!q.isEmpty()){
            if(sum > maxSum){
                maxSum = sum;
                maxLevel = level;
            }
            level++;
            int size = q.size();
            sum = 0;
            for(int i =0;i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    sum += node.left.val;
                    q.offer(node.left);
                }
                if(node.right != null){
                    sum += node.right.val;
                    q.offer(node.right);
                }
            }
            
        }
        return maxLevel;
    }
}