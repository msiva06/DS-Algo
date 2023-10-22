package Stacks;

import java.util.Stack;

// Decode String
public class Problem_08 {
  public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c != ']'){
                stack.push(c);
            }
            else{
                StringBuilder e = new StringBuilder();
                while(stack.peek() != '['){
                    e.append(stack.pop());
                }
                stack.pop();
                int num = 0;
                int base =1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num = num + (stack.pop() - '0') * base;
                    base *= 10;
                }

                String st = new String(e).repeat(num);
                for(int i = st.length()-1; i >=0 ; i--)
                    stack.push(st.charAt(i));
            }
        }
        char[] en = new char[stack.size()];
        for(int i = en.length-1; i >= 0; i--){
            en[i] = stack.pop();
        } 
        return new String(en);
    }  
}
