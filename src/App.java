import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums1 = { 2, 10, 13, 14, 18, 0, 0, 0 };
        int[] nums2 = { 1, 5, 6 };

        merge(nums1, (nums1.length - nums2.length), nums2, nums2.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // We know that the two arrays are sorted, and nums1 array has empty space for nums2
        // So, instead start from the beginning, it's better to start from the end
        
        // Index of the last item in nums1
        int last = m + n - 1;

        // We'll iterate through nums1 and nums2 from the end 
        // So, we need to check that m & n are both > 0, ohterwise we go outside the loop
        while(m > 0 && n > 0) {
            //We compare nums1[m - 1] which is the last element at nums1 with nums2[n - 1]
            // which is the last element at nums2, if (nums1[m - 1] > nums2[n - 1]) then
            // copy nums1[m - 1] at the last index nums1[last], then we decrement 
            // both (m & last) pointers.
            // nums1: { 1, 10, 13, 14, 18, 0, 0,    0 }
            //                         m^       last^
            // nums1: { 1, 5, 6 }
            //                n^
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[last--] = nums1[m - 1];
                m--;
                System.out.println(Arrays.toString(nums1));
                // nums1: { 1, 10, 13, 14, 18, 0,    0, 18 }
                //                     m^        last^   
                // nums1: { 1, 5, 6 }
                //                n^
            } else {
                nums1[last--] = nums2[n - 1];
                n--;
                System.out.println(Arrays.toString(nums1));
            }
        }

        // Edge case handler to put any values that might be left from nums2 into nums1
        while( n > 0) {
            nums1[last--] = nums2[n - 1];
            n--;
            System.out.println(Arrays.toString(nums1));
        }
    }
}
