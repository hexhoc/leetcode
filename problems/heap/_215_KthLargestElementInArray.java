package problems.heap;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 */
public class _215_KthLargestElementInArray {

    public static void main(String[] args) {
        var s = new _215_KthLargestElementInArray();
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
