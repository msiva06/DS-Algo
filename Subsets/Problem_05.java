package Subsets;

import java.util.ArrayList;
import java.util.List;

// Find K-sum subsets
public class Problem_05 {
    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
       int subsetCount = (int) Math.pow(2,setOfIntegers.size());
       List<List<Integer>> subsetList = new ArrayList<List<Integer>>();
       for(int i = 0; i < subsetCount; i++){
           List<Integer> subset = new ArrayList<>();
           for(int j = 0; j < setOfIntegers.size();j++){
               if(getBit(i,j) == 1){
                   subset.add(setOfIntegers.get(j));
               }
           }
           int sum  = subset.stream().reduce(0, Integer::sum);
           if(sum == targetSum)
            subsetList.add(subset);
       }
       return subsetList;
    }

    public static int getBit(int num,int bit){
        int temp = 1 << bit;
        temp = temp & num;
        if(temp == 0)
            return 0;
        return 1;
    }
}
