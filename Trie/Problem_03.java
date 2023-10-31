class TrieNode {
        public static final int SIZE = 26;
        TrieNode[] children = new TrieNode[SIZE];
        boolean isEOW;
}
// Replace words
public class Problem_03 {
    static TrieNode root = new TrieNode();
   public static String replaceWords(String sentence, List<String> dictionary) {
      for(String str : dictionary){
         insert(str);
      }
     
      String[] words = sentence.split(" ");
      StringBuilder sb = new StringBuilder();
      for(String word : words){
         StringBuilder sub = new StringBuilder();
          TrieNode node = root;
         for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null){
                if(sub.length() > 0){
                    sub = new StringBuilder();
                }
                sub.append(word);
                break;
            }
            else{
               node = node.children[idx];
               sub.append(c);
               if(node.isEOW)
                  break;    
            }
         }
         sub.append(" ");
         sb.append(sub);
      }
      sb.deleteCharAt(sb.length()-1);
      return new String(sb);
}
}
