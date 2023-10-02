package K-WayMerge;

// Merge Sorted Array
public class Problem_01 {
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
      
        int lnums1 = m - 1;
        int lnums2 = n - 1;
        int idx = nums1.length - 1;
        while(idx >= 0){
           if(lnums1 >= 0 && lnums2 >= 0 && nums1[lnums1] >= nums2[lnums2]){
              nums1[idx] = nums1[lnums1];
              lnums1--;
           }
           else {
              if(lnums2 >= 0){
                 nums1[idx] = nums2[lnums2];
                 lnums2--;
              }   
           }
           idx--;
        }
        return nums1;
     }
}
