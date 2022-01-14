package arrays.inserting;

import java.util.Arrays;

public class MergedSortedArray {
    public static void main(String[] args) {
        MergedSortedArray task = new MergedSortedArray();

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        task.execute(nums1, 3, nums2, 3);

    }

    public void execute(int[] nums1, int m, int[] nums2, int n) {
        
        for (int i = m; i < n+m; i++) {
            nums1[i] = nums2[i-n];
        }

        Arrays.sort(nums1);
    }
}
