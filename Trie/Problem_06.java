// Lexicographical numbers
public class Problem_06 {
    public static List<Integer> lexicographicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        Trie root = new Trie();
        for(int num =1; num <= Math.max(n,9); num++){
            Trie node = root;
            if(node.child[num] == null)
              node.child[num] = new Trie();
            node = node.child[num];
            node.val = num;
            node.isEnd = true;
        }
        
        if(n > 9){
            for(int i = 10; i <= n; i++){
                Trie node = root;
                int firstDigit = getFirstDigit(i);
                node = node.child[firstDigit];
                while(!node.isEnd){
                    node = node.child[firstDigit];
                }
                node.isEnd = false;
                node.child[firstDigit] = new Trie();
                node = node.child[firstDigit];
                node.val = i;
                node.isEnd = true;
            }
        }
        
        for(int num = 1; num <= Math.min(n,9); num++){
            Trie node = root;
            if(node.child[num] == null){
                continue;
            }
            node = node.child[num];
            while(!node.isEnd){
                res.add(node.val);
                node = node.child[num];
            }
            res.add(node.val);
        }
        return res;
     }
 
     public static int getFirstDigit(int i){
         int sum = 0;
         while(i > 0){
             int digit = i % 10;
             sum += (sum * 10) + digit;
             if(i/10 <= 0)
                 break;
             i = i / 10;
         }
         return i;
     }
}
