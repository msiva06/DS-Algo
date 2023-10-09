package Greedy;

import java.util.Arrays;

// Gas stations
public class Problem_03 {
    public static int gasStationJourney(int[] gas, int[] cost) {
      
      int totalGas = Arrays.stream(gas).sum();
      int totalCost = Arrays.stream(cost).sum();
      if(totalGas - totalCost < 0)
         return -1;

      int start = 0, currGas = 0,iter = 0;
      while(iter < gas.length){
         currGas += gas[iter] - cost[iter];
         if(currGas < 0){
            start = iter + 1;
            currGas = 0;
         }
         iter+=1;
      }

      return start;

   }
}
