package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// Asteroid Collision
public class Problem_07 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag = true;
        for(int i = 0; i < asteroids.length; i++){
            flag = true;
            int curr = asteroids[i];
            while(!stack.isEmpty() && stack.peek() > 0 && curr < 0){
                if(Math.abs(stack.peek()) < Math.abs(curr)){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(stack.peek()) == Math.abs(curr)){
                    stack.pop();
                }
                flag = false;
                break;
                    
            }
            if(flag)
                stack.push(curr);
               
        }
        List<Integer> res = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
