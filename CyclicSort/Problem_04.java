package CyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// First K missing numbers
public class Problem_04 {
    public static List<Integer> firstKMissingNumbers(int[] arr, int k) {
            int n = arr.length;
            int ind = 0;
            List<Integer> res = new ArrayList<Integer>();
            while(ind < n){
                int value = arr[ind]-1;
                if(value >= 0 && value < n && arr[ind] != arr[value]){
                    int temp = arr[ind];
                    arr[ind] = arr[value];
                    arr[value] = temp;
                }
                else if(value >= n) {
                    ind++;
                }
                else{
                    ind++;
                }
            }
            Set<Integer> present = new HashSet<Integer>();
            
            for(int i = 0; i < n; i++){
                if(i+1 != arr[i]){
                    res.add(i+1);
                    
                }
                present.add(arr[i]);
            }
            int val = 0;
            res.stream().forEach(System.out::println);
            if(res.isEmpty())   
            {
                val = arr[arr.length-1] + 1;
            }
            while(res.size() < k){ 
                if(!res.isEmpty()){
                   val = res.get(res.size()-1) + 1; 
                }
                while(present.contains(val)){
                    val += 1;
                }
                res.add(val);
            }
            while(res.size() > k)
                res.remove(res.size()-1); 
            return res;
    }
}
