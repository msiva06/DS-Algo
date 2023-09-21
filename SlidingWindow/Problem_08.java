package SlidingWindow;

// Best time to buy and sell stock
public class Problem_08 {
    public static int maxProfit(int[] stockPrices) {
      
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < stockPrices.length; i++){
           if(stockPrices[i] < minSoFar)
              minSoFar = stockPrices[i];
           else
              maxProfit = Math.max(maxProfit, stockPrices[i] - minSoFar);
        }
        return maxProfit;
     }
}
