package ModifiedBinarySearch;

// KOKO eating bananas
public class Problem_07 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles = Integer.MIN_VALUE;
        for(int pile : piles)
            maxPiles = Math.max(maxPiles,pile);
        int left = 1, right = maxPiles;
        while(left < right){
            int mid = left + (right - left)/2;
            if(calcHrs(piles,mid) > h){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    public int calcHrs(int[] piles, int speed){
        int sum = 0;
        for(int pile:piles){
            sum += Math.ceil((double)pile/speed);
        }
        return sum;
    }
}
