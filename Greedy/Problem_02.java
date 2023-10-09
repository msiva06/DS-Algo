package Greedy;

import java.util.Arrays;

// Boats to save people
public class Problem_02 {
    public static int rescueBoats(int[] people, int limit) {
     Arrays.sort(people);
     int left = 0, right = people.length-1;
     int boats = 0;
     while(left <= right){
        if(people[left] + people[right] <= limit){
           left++;
           right--;
        }
        else if(people[left] + people[right] > limit){
           right--;
        }
        boats++;
     }
     return boats;
   }
}
