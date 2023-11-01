// Word Search II
public class Problem_05 {
    public static List<String> findStrings(char[][] grid, String[] words){
        Trie t = new Trie();
        for(String word:words){
            TrieNode node = t.root;
            for(char c : word.toCharArray())
            {
                if(!node.children.containsKey(c))
                    node.children.put(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isString = true;
        }
        List<String> res = new ArrayList<>();
        for(int row = 0; row < grid.length; row ++){
            for(int col = 0; col < grid[0].length; col++){
                dfs(t.root,res,grid,row,col,new String());
            }
        }
        return res;
    }

    public static void dfs(TrieNode node,List<String> res,char[][] grid,int row,int col,String word){
        if(node.isString){
            res.add(word);
            node.isString = false;
        }

        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length){
            char c = grid[row][col];
            node = node.children.get(c);
            if(node != null){
                String newWord = word + c;
                int[][] offset = {{0,1},{0,-1},{1,0},{-1,0}};
                grid[row][col] = 0;
                for(int[] off:offset){
                    int rowoff = off[0];
                    int coloff = off[1];
                    System.out.println(rowoff + " " + coloff);
                    dfs(node,res,grid,row+rowoff, col+coloff,newWord);
                }
                grid[row][col] = c;
            }
        }
    }
}
