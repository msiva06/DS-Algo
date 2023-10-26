package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// Valid Tree
public class Problem_04 {
    public static boolean validTree(int n, int[][] edges) {
        int edgLen = edges.length;
        if(edgLen != n-1)
            return false;
        List<List<Integer>> adjList = new ArrayList<>(Collections.nCopies(n,new ArrayList<>()));
        for(int i = 0; i < edgLen; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited.contains(node))
                continue;
            visited.add(node);
            for(int p: adjList.get(node)){
                stack.push(p);
            }
        }
        if(visited.size() == n)
            return true;
        return false;
    }
}
