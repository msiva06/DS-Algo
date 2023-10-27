// Leaf similar trees
public class Problem_14 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<Integer>();
        List<Integer> root2List = new ArrayList<Integer>();
        getLeafList(root1,root1List);
        getLeafList(root2,root2List);

        if(root1List.size() != root2List.size())
            return false;
        for(int i =0 ; i < root1List.size();i++){
            if(root1List.get(i) != root2List.get(i))
                return false;
        }
        return true;
    }

    public void getLeafList(TreeNode root,List<Integer> rootList){
        if(root != null && root.left == null && root.right == null){
            rootList.add(root.val);
            return;
        }
        if(root != null && root.left != null)
            getLeafList(root.left,rootList);
        if(root != null && root.right != null)
            getLeafList(root.right,rootList);
    }
}
