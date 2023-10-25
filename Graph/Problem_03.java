package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }
}

// Clone Graph
public class Problem_03 {
        public static Node clone(Node root) {
        return cloneGrp(root,new HashMap<Node,Node>());
    }

    public static Node cloneGrp(Node root, HashMap<Node,Node> neigh){
        if(root == null)
            return null;
        
        Node cloneNode = new Node(root.data);
        neigh.put(root,cloneNode);
        for(Node n : root.neighbors){
            Node p = neigh.get(n);
            if(p == null){
                cloneNode.neighbors.add(cloneGrp(n,neigh));
            }
            else{
                cloneNode.neighbors.add(p);
            }
        }
        return cloneNode;
    }
}
