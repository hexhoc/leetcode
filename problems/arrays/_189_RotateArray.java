package problems.arrays;

import static util.Assertions.assertEquals;

/*
189. Rotate Array
Medium
 */
public class _189_RotateArray {

    public static void main(String[] args) {
        var s = new _189_RotateArray();
        var nums1 = new int[]{1, 2};
        var nums2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        var nums3 = new int[]{1,2,3,4};

        s.executeWithoutExtraMemory(nums1, 5);
        s.executeWithoutExtraMemory(nums2, 3);
        s.executeWithoutExtraMemory(nums3, 2);

        assertEquals(new int[]{2,1}, nums1);
        assertEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums2);
        assertEquals(new int[]{3,4,1,2}, nums3);
    }

    public void executeWithExtraMemory(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums2[i] = nums[nums.length - k + i];
            } else {
                nums2[i] = nums[i - k];
            }
        }

        System.arraycopy(nums2, 0, nums, 0, nums.length);
    }

    public void executeWithoutExtraMemory(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
