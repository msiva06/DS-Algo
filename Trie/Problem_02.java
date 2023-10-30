import java.util.ArrayList;
import java.util.Arrays;

class Node{
    public Node(){
        Node[] child = new Node[26];
        List<String> searchWords = new LinkedList<>();
    }
}

// Search suggestions system
public class Problem_02 {
    Node root = new Node();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String prod : products){
            insert(prod);
        }
        return search(searchWord);
    }

    public void insert(String product){
        Node node = root;
        for(char c : product.toCharArray()){
            int idx = c - 'a';
            if(node.child[idx] == null){
                node.child[idx] = new Node();
            }
            node = node.child[idx];
            node.searchWords.offer(product);
            if(node.searchWords.size() > 3)
                node.searchWords.pollLast();
        }
    }

    public List<List<String>> search(String searchWord){
        Node node = root;
        List<List<String>> res = new ArrayList<>();
        for(char c : searchWord.toCharArray()){
            int idx = c - 'a';
            if(node != null)
                node = node.child[idx];
            res.add(node == null ?  Arrays.asList() : node.searchWords);
        }
        return res;
    }
}
