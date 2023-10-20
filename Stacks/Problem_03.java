package Stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// Minimum remove parantheses
public class Problem_03 {
    public static String minRemoveParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> indexToRemove = new HashSet<Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')')
            {
                if(stack.isEmpty())
                    indexToRemove.add(i);
                else
                    stack.pop();
            }   
            else if(c == '(')
                stack.add(i);  
        }
        while(!stack.isEmpty()){
            indexToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!indexToRemove.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
