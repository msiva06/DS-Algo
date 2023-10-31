import java.util.ArrayList;

class TrieNode {
  public TrieNode[] children;
  public boolean complete;

  public TrieNode() {
    children = new TrieNode[26];
    complete = false;
  }
}

// Design add and search words data structure
public class Problem_04 {
    TrieNode root;
    boolean canFind;
    public Problem_04(){
        root = new TrieNode();
        canFind = false;
    }

    public void addWord(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.complete = true;
    }

    public boolean searchWord(String word){
        TrieNode node = root;
        canFind = false;
        searchHelper(node,word,0);
        return canFind;
    }

    public void searchHelper(TrieNode node,String word,int idx){
        if(canFind)
            return;
        if(node == null)
            return;
        if(idx == word.length()){
            if(node.complete)
                canFind = true;
            return;
        }
        if(word.charAt(idx) == '.'){
            for(int i = (int)'a'; i<= (int)'z'; i++){
                searchHelper(node.children[(char)(i-'a')], word, idx+1);
            }
        }
        else{
            char c = word.charAt(idx);
            searchHelper(node.children[c - 'a'], word, idx+1);
        }
    }

    public List<String> getWords(){
        List<String> res = new ArrayList<>();
        TrieNode node = root;
        return dfs(res,node,"");
    }

    public List<String> dfs(List<String> res,TrieNode node,String word){
        if(node == null)
            return res;
        if(node.complete)
            res.add(word);
        for(int i = (int)'a'; i<=(int)'z'; i++){
            String prefix = word + (char)i;
            dfs(res,node.children[(char) i - 'a'],prefix);
        }
        return res;
    }
}
