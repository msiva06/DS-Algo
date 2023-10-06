package ModifiedBinarySearch;

// Search in Rotated Sorted Array II
public class Problem_05 {
    public static boolean search(int[] arr, int t) {
      
        int left = 0, right = arr.length -1;
        while(left <= right && arr[left] == arr[right]){
           if(arr[left] == t)
              return true;
           left++;
           right--;
        }
        while(left <= right){
           int mid = left + (right - left)/2;
           if(t == arr[mid])
              return true;
           else if(arr[left] <= arr[mid]){
              if(arr[left] <= t && t <= arr[mid]){
                 right = mid-1;
              }
              else{
                 left = mid+1;
              }
           }
           else {
              if(arr[mid] <= t && t <= arr[right]){
                 left = mid + 1;
              }
              else{
                 right = mid -1;
              }
           }
        }
        return false;
     }
}
