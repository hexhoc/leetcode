package problems.arrays;

import java.util.Arrays;

/*
189. Rotate Array
Medium
 */
public class _189_RotateArray {

    public static void main(String[] args) {
        var s = new _189_RotateArray();
        var nums1= new int[]{1,2};
        var nums2= new int[]{1,2,3,4,5,6,7};
        s.rotate(nums1, 3);
        s.rotate(nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void rotate(int[] nums, int k) {
        if (k % nums.length == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        int startIndex = nums.length - k % nums.length;
        for (int i = 0; i < temp.length; i++) {
            if (startIndex >= nums.length) {
                startIndex = 0;
            }
            temp[i] = nums[startIndex];
            startIndex++;
        }

        System.arraycopy(temp, 0, nums, 0, temp.length);
    }
}
