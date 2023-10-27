import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Serialize and deserialize a tree
public class Problem_03 {
    public static List<String> serialize(TreeNode<Integer> root) {
        List<String> seriList = new ArrayList<>();
        serializeToList(root,seriList);
        return seriList;
    }

    public static void serializeToList(TreeNode<Integer> root,List<String> seriList){
        if(root == null){
            seriList.add("NULL");
            return;
        }  
        seriList.add(String.valueOf(root.data));
        serializeToList(root.left,seriList);
        serializeToList(root.right,seriList);
    }
    public static TreeNode<Integer> deserialize(List<String> stream){
        Collections.reverse(stream);
        return deserializeFromList(stream);
    }

    public static TreeNode<Integer> deserializeFromList(List<String> stream){
        String val = stream.remove(stream.size()-1);
        if(val.equals("NULL"))
            return null;
        TreeNode<Integer> root = new TreeNode<Integer>(Integer.parseInt(val));
        
        root.left = deserializeFromList(stream);
        root.right = deserializeFromList(stream);
        return root;
    }
}
