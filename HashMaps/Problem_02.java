// Logger Rate limiter
public class Problem_02 {
    Map<String,Integer> map;
	int timeLimit;
	public Problem_02(int timeLimit) {
		map = new HashMap<>();
		this.timeLimit = timeLimit;
	}

	public boolean messageRequestDecision(int timestamp, String request) {
		if(map.isEmpty() || !map.containsKey(request)){
			map.put(request,timestamp);
		}
		else{
			Integer timeSt = map.get(request);
			if(timestamp - timeSt < timeLimit){
				return false;
			}
			else{
				map.put(request,timestamp);
			}
				
		}
		return true;
	}
}
