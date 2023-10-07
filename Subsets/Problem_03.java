package Subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Letter combinations of a phone number
public class Problem_03 {
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<String>();
        Map<Character,String[]> comb = new HashMap<>();
        StringBuilder path = new StringBuilder();
        comb.put('1',new String[]{});
        comb.put('2',new String[]{"a","b","c"});
        comb.put('3',new String[]{"d","e","f"});
        comb.put('4',new String[]{"g","h","i"});
        comb.put('5',new String[]{"j","k","l"});
        comb.put('6',new String[]{"m","n","o"});
        comb.put('7',new String[]{"p","q","r","s"});
        comb.put('8',new String[]{"t","u","v"});
        comb.put('9',new String[]{"w","x","y","z"});
        if(digits.length() == 0)
            return res;
        backtrack(res,comb,path,digits,0);
        return res;
    }

    public void backtrack(List<String> res,Map<Character,String[]> comb,StringBuilder path,String digits,int index){
        if(path.length() == digits.length()){
            res.add(new String(path));
            return;
        }
        char l = digits.charAt(index);
        String[] lComb = comb.get(l);
        for(String s : lComb){
            path.append(s);
            backtrack(res,comb,path,digits,index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
