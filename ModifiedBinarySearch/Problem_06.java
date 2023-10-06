package ModifiedBinarySearch;

import java.util.Arrays;

// Successful pairs of spells and portions
public class Problem_06 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successPairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){
            successPairs[i] = getPairCount(spells[i],potions,success);
        }
        return successPairs;
    }

    public static int getPairCount(int spell, int[] potions,long success){
        int left = 0, right = potions.length -1;
        long product = 1;
        while(left < right){
            int mid = left + (right - left)/2;
            product = (long) potions[mid] * spell;
            if(product >= success){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        long leftProdCheck = (long) potions[left] * spell;
        int firstPairSuccess = (left == potions.length-1 && leftProdCheck < success)? potions.length : left;
        int remainingPairs = potions.length - firstPairSuccess;
        return remainingPairs;
    }
}
