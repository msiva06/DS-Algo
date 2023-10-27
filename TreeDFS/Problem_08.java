// Build tree from Inorder and Preorder
public class Problem_08 {
    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {
        Map<Integer,Integer> iOrderIdxMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < iOrder.length; i++){
            iOrderIdxMap.put(iOrder[i],i);
        }
        int[] pinOrder = new int[1];
        return buildTr(pOrder,iOrder,pinOrder,0,pOrder.length-1,iOrderIdxMap);
    }

    public static TreeNode<Integer> buildTr(int[] pOrder,int[] iOrder,int[] pinOrder, int left,int right,
        Map<Integer,Integer> iOrderIdxMap){
        if(left > right)
            return null;
        TreeNode<Integer> root = new TreeNode<Integer>(pOrder[pinOrder[0]]);
        int idx = iOrderIdxMap.get(pOrder[pinOrder[0]]);
        pinOrder[0]++;
        root.left = buildTr(pOrder,iOrder,pinOrder,left,idx-1,iOrderIdxMap);
        root.right = buildTr(pOrder,iOrder,pinOrder,idx+1,right,iOrderIdxMap);
        return root;
    }
}
