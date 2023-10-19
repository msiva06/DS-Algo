package Stacks;

import java.util.Stack;

// Remove Adjacent Duplicates
public class Problem_02 {
    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<Character>();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(stack.isEmpty())
                stack.add(c[i]);
            else if(!stack.isEmpty() && stack.peek() == c[i]){
                stack.pop();
                continue;
            }
            else{
                stack.add(c[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return new String(sb.reverse());
    }
}
