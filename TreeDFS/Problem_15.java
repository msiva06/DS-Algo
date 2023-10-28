// Longest zigzag path in binary tree
public class Problem_15 {
    public int longestZigZag(TreeNode root) {
        int[] maxPath = new int[1];
        longZig(root,"R",0,maxPath);
        longZig(root,"L",0,maxPath);
        return maxPath[0];
    }

    public void longZig(TreeNode root,String dir, int path, int[] maxPath){
        if(root == null)
            return;
        maxPath[0] = Math.max(maxPath[0],path);
        if(dir.equals("L")){
            longZig(root.left,"R",path+1,maxPath);
            longZig(root.right,"L",1,maxPath);
        }
        else{
            longZig(root.left,"R",1,maxPath);
            longZig(root.right,"L",path+1,maxPath);
        }
    }
}
