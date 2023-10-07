package Subsets;

import java.util.ArrayList;

//Generate parantheses
public class Problem_04 {
    public static ArrayList<String> generateCombinations(int n) {
		
        ArrayList<String> result = new ArrayList<String>();
        backtrack(0,0,n,new StringBuilder(),result);
		return result;
	}

    public static void backtrack(int open, int closed, int n, StringBuilder sb, ArrayList<String> result){
        if(open == n && closed == n){
            result.add(new String(sb));
            return;
        }

        if(open < n){
            sb.append("(");
            backtrack(open +1,closed,n,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closed < open){
            sb.append(")");
            backtrack(open, closed+1,n,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
