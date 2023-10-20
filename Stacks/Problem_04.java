package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Event {
		private int id;
		private boolean isStart;
		private int time;

		public Event(String content) {
			String[] strs = content.split(":");
			this.id = Integer.valueOf(strs[0]);
			this.isStart = strs[1].equals("start");
			this.time = Integer.valueOf(strs[2]);
		}
        public int getId(){
            return this.id;
		}
        public boolean getIsStart(){
            return this.isStart;
		}
        public int getTime(){
            return this.time;
		}
	}


// Exclusive execution time of functions
    public class Problem_04 {
    public static List<Integer> exclusiveTime(int n, List<String> events) {
        List<Integer> res = new ArrayList<Integer>(Collections.nCopies(n,0));
        Stack<Event> stack = new Stack<>();
        for(int i =0; i < events.size(); i++){
            Event eve = new Event(events.get(i));
            if(eve.getIsStart()){
                stack.push(eve);
            }
            else{
                Event popped = stack.pop();
                res.set(popped.getId(),res.get(popped.getId()) + (eve.getTime() - popped.getTime() + 1));
                if(!stack.isEmpty()){
                    res.set(stack.peek().getId(), res.get(stack.peek().getId()) - (eve.getTime() - popped.getTime() + 1));
                }
            }
        }
        return res;
    }
}
