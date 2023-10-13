package CyclicSort;

// Missing Number
public class Problem_01 {

    public static int findMissingNumber(int[] arr) {
      
        int n = arr.length;
        int i = 0;
  
        while(i < n){
           if(i != arr[i] && arr[i] < n){
              int temp = arr[i];
              arr[i] = arr[temp];
              arr[temp] = temp;
           }
           else if(arr[i] >= n){
              i++;
           }
           else{
              i++;
           }
        }
  
        for(int j = 0; j < arr.length; j++){
           if(j != arr[j])
              return j;
        }
        return n;
     }
}
