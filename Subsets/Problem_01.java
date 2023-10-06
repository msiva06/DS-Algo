package Subsets;

import java.util.ArrayList;
import java.util.List;

// Subsets
public class Problem_01 {
    public static List<List<Integer>> findAllSubsets(int[] nums) {
		
		int subsetcount = (int) Math.pow(2, nums.length);
		List<List<Integer>> setsList = new ArrayList<>();
		for(int i =0; i< subsetcount; i++){
			List<Integer> subset = new ArrayList<>();
			for(int j = 0; j < nums.length; j++){
				if(getBit(i,j) == 1){
					subset.add(nums[j]);
				}
			}
			setsList.add(subset);
		}
		return setsList;
	}

	public static int getBit(int num,int bit){
		int temp = 1 << bit;
		temp = temp & num;
		if(temp == 0)	
			return 0;
		return 1;
	}
}
