// Fraction to Recurring decimal
public class Problem_01 {
    public static String fractionToDecimal (int numerator, int denominator) {
        StringBuilder fraction = new StringBuilder();
        if(numerator == 0)
           return "0";
        if(numerator < 0 ^ denominator < 0)
           fraction.append("-");
  
        long divident = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(divident/divisor));
        long remainder = divident % divisor;
        if(remainder == 0)
           return fraction.toString();
        fraction.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while(remainder != 0){
           if(map.containsKey(remainder)){
              fraction.insert(map.get(remainder), "(");
              fraction.append(")");
              break;
           }
           map.put(remainder,fraction.length());
           remainder *= 10;
           fraction.append(String.valueOf(remainder/divisor));
           remainder %= divisor;
        }
        return fraction.toString();
  }
}
