package FastAndSlowPointers;

// Happy Number
public class Problem_01 {
    public static boolean isHappyNumber(int n) {

        // Replace this placeholder return statement with your code
        int slow = n, fast = sumOfSquaredDigits(n);
        while(fast != slow && fast != 1){
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        return fast == 1;
    }

    public static int sumOfSquaredDigits(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
