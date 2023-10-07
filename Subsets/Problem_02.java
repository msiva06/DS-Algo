package Subsets;

import java.util.ArrayList;

// Permutations
public class Problem_02 {
    public static ArrayList<String> permuteWord(String word) {

        ArrayList<String> permutations = new ArrayList<String>();
        backtrack(permutations,word,0);
        return permutations;
    }

    public static void backtrack(ArrayList<String> permutations,String word,int index){
        if(index == word.length()){
            permutations.add(word);
            return;
        }

        for(int i = index; i < word.length(); i++){
            char[] swapped = swap(word,i,index);
            backtrack(permutations,String.valueOf(swapped),index+1);
        }
    }

    public static char[] swap(String word,int i, int j){
        char[] c = word.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }
}
