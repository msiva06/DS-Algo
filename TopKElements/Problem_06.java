package TopKElements;

import java.util.PriorityQueue;

// Total cost to hire K workers
public class Problem_06 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<Integer>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<Integer>();
        int next_head = candidates;
        int next_tail = costs.length - candidates - 1;
        long totalCost = 0;
        for(int i = 0; i < candidates; i++){
            headWorkers.add(costs[i]);
        }
        for(int i = Math.max(candidates,costs.length-candidates); i < costs.length; i++){
            tailWorkers.add(costs[i]);
        }
        
        while(k > 0){
            if(tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()){
                totalCost += headWorkers.poll();
                if(next_head <= next_tail){
                    headWorkers.add(costs[next_head]);
                    next_head += 1;
                } 
            }
            else{
                totalCost += tailWorkers.poll();
                if(next_head <= next_tail){
                    tailWorkers.add(costs[next_tail]);
                    next_tail -= 1;
                } 
            }
            k--;
        }
        return totalCost;
    }
}
