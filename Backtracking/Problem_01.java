package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// N Queens
public class Problem_01 {
    public static int solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>(Collections.nCopies(n, -1));
        backtrack(0,res,sol,n);
        return res.size();
    }

    public static void backtrack(int row, List<List<Integer>> res, List<Integer> sol,int n){
        if(row == n){
            res.add(sol);
            return;
        }

        for(int i = 0; i < n; i++){
            if(isValid(row,i,sol)){
                sol.set(row, i);
                backtrack(row + 1,res,sol,n);
            }
        }

    }

    public static boolean isValid(int row,int col, List<Integer> sol){
        int oldRow = 0, oldCol = 0, dOffset = 0;
        for(int i = 0; i < row; i++){
            oldRow = i;
            oldCol = sol.get(oldRow);
            dOffset = row - oldRow;
            if(oldCol == col || oldCol == col - dOffset || oldCol == col + dOffset){
                return false;
            }
            
        }
        return true;
    }
}
