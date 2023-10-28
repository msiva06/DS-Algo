// Vertical order traversal of binary tree

import java.util.List;
import java.util.Map;

public class Problem_04 {
    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> out = new ArrayList<>();
        Map<Integer,List<Integer>> nodeList = new HashMap<>();
        Queue<Map.Entry<TreeNode<Integer>,Integer>> queue = new LinkedList<>();
        int col = 0;
        int minCol = 0, maxCol = 0;
        queue.offer(new AbstractMap.SimpleEntry<>(root,col));
        while(!queue.isEmpty()){
            Map.Entry<TreeNode<Integer>,Integer> val = queue.poll();
            root = val.getKey();
            col = val.getValue();
            if(root != null){
                if(!nodeList.containsKey(col)){
                    nodeList.put(col,new ArrayList<>());
                }
                nodeList.get(col).add(root.data);
                minCol = Math.min(minCol,col);
                maxCol = Math.max(maxCol,col);
                queue.offer(new AbstractMap.SimpleEntry<>(root.left,col-1));
                queue.offer(new AbstractMap.SimpleEntry<>(root.right,col+1));
            }
        }
        for(int i = minCol; i<= maxCol; i++){
            out.add(nodeList.get(i));
        }
        return out;
    }
}
