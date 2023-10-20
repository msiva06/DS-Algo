package Stacks;

import java.util.Stack;

// Valid Parantheses
public class Problem_05 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else{
                if(!stack.isEmpty())
                    stack.pop();
                else
                    stack.push(c);
            }
                
        }
        return stack.isEmpty();
    }
}
