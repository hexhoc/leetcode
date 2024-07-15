package problems.arrays;

/*
88. Merge Sorted Array
easy
*/

import static util.Assertions.assertEquals;

import java.util.Arrays;

public class _88_MergedSortedArray {

    public static void main(String[] args) {
        _88_MergedSortedArray s = new _88_MergedSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        s.execute(nums1, 3, nums2, 3);

        assertEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    public void execute(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

}
