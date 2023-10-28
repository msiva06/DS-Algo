// Path Sum III
public class Problem_16 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        findPath(root,targetSum,0);
        return count;
    }

    public void findPath(TreeNode root,int sum,long currSum){
        if(root == null)
            return;
        currSum += root.val;
        if(sum == currSum)
            count++;
        findPath(root.left,sum,currSum);
        findPath(root.right,sum,currSum);
        
    }
}
