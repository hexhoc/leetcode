package problems.arrays.deleting;

import static util.Assertions.assertEquals;

public class _27_Remove_Element {

    public static void main(String[] args) {
        int[] arr1 = new int[] {3, 2, 2, 3};
        int[] arr2 = new int[] {0, 1, 2, 2, 3, 0, 4, 2};

        var s = new _27_Remove_Element();
        var k1 = s.executeVer1(arr1, 3);
        var k2 = s.executeVer1(arr2, 2);

        assertEquals(2, k1);
        assertEquals(5, k2);
        assertEquals(new int[]{2, 2, 0, 0}, arr1);
        assertEquals(new int[]{0, 1, 4, 0, 3}, arr2);
    }

    public int executeVer1(int[] nums, int val) {
        int k = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                while (k > i && nums[i] == val) {
                    nums[i] = nums[k];
                    nums[k] = 0;
                    k--;
                }
            }
        }
        return k + 1;
    }

    public int executeVer2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
            if (i > k) {
                nums[i] = 0;
            }
        }

        return k;
    }
}
