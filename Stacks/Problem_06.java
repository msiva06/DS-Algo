package Stacks;

import java.util.Stack;

// Removing stars from String
public class Problem_06 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(!stack.isEmpty() && curr == '*'){
                stack.pop();
                continue;
            }
            else{
                stack.add(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
