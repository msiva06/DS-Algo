package Backtracking;

import java.util.ArrayList;
import java.util.List;

// Combination Sum III
public class Problem_08 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> combination = new ArrayList<Integer>();
        List<List<Integer>> combinationList = new ArrayList<List<Integer>>();
        if(n < k)
            return combinationList;
        backtrack(1,combination,combinationList,k,n,0);
        return combinationList;
    }

    public  void backtrack(int i,List<Integer> combination,List<List<Integer>> combinationList,int k,int sum,int tempSum){
        if(tempSum == sum && combination.size() == k){
            combinationList.add(new ArrayList<>(combination));
            return;
        }
        for(int j = i; j <= 9; j++){
            combination.add(j);
            backtrack(j+1,combination,combinationList,k,sum,tempSum+j);
            combination.remove(combination.size()-1);
        }
    }
}
