class TrieNode {
  boolean isWord;
  HashMap < Character,
  TrieNode > children;
  public TrieNode() {
    this.children = new HashMap < Character,
    TrieNode > ();
    this.isWord = false;
  }
}

// Implement Trie
public class Problem_01 {
    TrieNode root;
    public Problem_01() {
        root = new TrieNode();
    }

    // inserting string in trie
    public void insert(String word) {
        TrieNode trie = this.root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!trie.children.containsKey(c))
                trie.children.put(c, new TrieNode());
            trie = trie.children.get(c);
        }
        trie.isWord = true;
    }

    // searching for a string
    public boolean search(String word) {
        TrieNode trie = this.root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(!trie.children.containsKey(c))
                return false;
            trie = trie.children.get(c);
        }
        return trie.isWord;
    }

    // searching for a prefix
    public boolean searchPrefix(String prefix) {
        TrieNode trie = this.root;
        for(int i =0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!trie.children.containsKey(c))
                return false;
            trie = trie.children.get(c);
        }
        return true;
    }
}
