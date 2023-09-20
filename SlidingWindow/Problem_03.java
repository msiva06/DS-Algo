package SlidingWindow;

// Maximum Average Subarray I
public class Problem_03 {

    public double findMaxAverage(int[] nums, int k) {
        double output = 0;
        double avg = 0;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
            avg = (double)sum/k; 
        }
        output = avg;
        int left = 0, right = k;
        while(right < nums.length){
            sum -= nums[left];
            sum += nums[right];
            avg =(double) sum/k;
            output = Math.max(output,avg);
            left++;
            right++;
        }
        return output;

    }
}
