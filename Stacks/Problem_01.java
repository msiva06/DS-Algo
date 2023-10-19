package Stacks;

import java.util.Stack;

// Basic Calculator
public class Problem_01 {
    public static int calculator(String expression) {
        char[] exp = expression.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0, result = 0, signVal = 1;
        for(int i = 0; i < exp.length; i++){
            char c = exp[i];
            if(Character.isDigit(c)){
                number = (number * 10) + Character.getNumericValue(c);
            }
            else if(c == '+' || c == '-'){
                result += number * signVal;
                if(c == '+')
                    signVal = 1;
                else    
                    signVal = -1;
                number = 0;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(signVal);
                result = 0;
                signVal = 1;
            }
            else if(c == ')'){
                result += number * signVal;
                int popSign = stack.pop();
                result *= popSign;
                int secNum = stack.pop();
                result += secNum;
                number = 0;
            }
        }
        return result + number * signVal;
    }
}
