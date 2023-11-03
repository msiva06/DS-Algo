// Maximum Frequency Stack
public class Problem_05 {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> stackFreq;
    int maxFreq;
    public Problem_05() {
        freq = new HashMap<>();
        stackFreq = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int value) {
        freq.put(value, freq.getOrDefault(value,0) + 1);
        if(freq.get(value) > maxFreq)
            maxFreq = freq.get(value);
        if(!stackFreq.containsKey(freq.get(value)))
            stackFreq.put(freq.get(value), new Stack<>());
        stackFreq.get(freq.get(value)).push(value);
    }

    public int pop() {
       int show = -1;
       if(maxFreq > 0){
         
           show = stackFreq.get(maxFreq).pop();
             System.out.println(show);
           freq.put(show, freq.get(show)-1);
           if(stackFreq.get(maxFreq).size() == 0)
            maxFreq--;
       }
       return show;
    }
}
