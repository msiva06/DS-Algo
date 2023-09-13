package TwoPointers;

// Reverse Words in a string
public class Problem_05 {
    public static String reverseWords(String sentence) {

        sentence = sentence.trim();
        StringBuilder sb = new StringBuilder(sentence);
        sb.reverse();
        int start =0, end =0;
        StringBuilder wordRev = new StringBuilder();
        while(end < sentence.length()){
             while(sb.charAt(start) == ' '){
                    start++;
                    end++;
                }
            if(sb.charAt(end) == ' '){
               
                StringBuilder word = new StringBuilder(sb.substring(start, end));
                wordRev.append(word.reverse());
                wordRev.append(' ');
                start = end+1;   
            }
            end = end+1;
        }
         StringBuilder word = new StringBuilder(sb.substring(start, end));
        wordRev.append(word.reverse());
        return new String(wordRev);
    }
}
