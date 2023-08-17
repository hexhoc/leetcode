package top_interview_150.array_string;

/*
88. Merge Sorted Array
easy
*/

import java.util.Arrays;

public class MergedSortedArray {
    public static void main(String[] args) {
        MergedSortedArray task = new MergedSortedArray();

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        task.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}
