// Word Ladder
public class Problem_06 {
    public static int wordLadder(String src, String dest, List<String> words) {
        Set<String> mySet = new HashSet<>(words);

        if (!mySet.contains(dest))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(src);
        int length = 0;

        while (!q.isEmpty()) {
            length++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                for (int j = 0; j < curr.length(); j++) {
                    String alpha = "abcdefghijklmnopqrstuvwxyz";
  
                    for (int k = 0; k < alpha.length(); k++) {
                        char[] temp = curr.toCharArray();
                        temp[j] = alpha.charAt(k);
                        String newWord = new String(temp);
      
                        if (newWord.equals(dest))
                            return length + 1;
                       
                        if (mySet.contains(newWord)) {
                            q.offer(newWord);
                            mySet.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
