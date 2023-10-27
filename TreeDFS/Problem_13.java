// Count good nodes in binary tree
public class Problem_13 {
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        countGood(root,Integer.MIN_VALUE,count);
        return count[0];
    }

    public void countGood(TreeNode root, int maxSoFar,int[] count){
        if(maxSoFar <= root.val){
            count[0]++;
        }
        maxSoFar = Math.max(root.val,maxSoFar);
        if(root.left != null)
            countGood(root.left,maxSoFar,count);
        if(root.right != null)
            countGood(root.right,maxSoFar,count);
       

    }
}
