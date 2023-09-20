package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

// Find Maximum in Sliding window
public class Problem_02 {
    public static int[] findMaxSlidingWindow(int[] nums, int w) {

		List<Integer> output = new ArrayList<>();
		for(int i = 0; i < nums.length-w+1;i++){
			int max = Integer.MIN_VALUE;
			for(int j = i; j< i+w;j++){
				max = Math.max(max,nums[j]);
			}
			output.add(max);
		}
		
		return output.stream().mapToInt(Integer::intValue).toArray();
	}
}
