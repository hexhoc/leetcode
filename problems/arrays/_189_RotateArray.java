package problems.arrays;

import static util.Assertions.assertEquals;

/*
189. Rotate Array
Medium
 */
public class _189_RotateArray {

    public static void main(String[] args) {
        var s = new _189_RotateArray();
        var nums1 = new int[]{1,2};
        var nums2 = new int[]{1,2,3,4,5,6,7};
        s.execute(nums1, 5);
        s.execute(nums2, 3);

        assertEquals(new int[]{5,6,7,1,2,3,4}, nums2);
    }

    public void execute(int[] nums, int k) {
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
}
