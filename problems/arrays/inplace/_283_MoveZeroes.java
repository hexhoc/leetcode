package problems.arrays.inplace;

import static util.Assertions.assertEquals;

import problems.arrays.deleting._80_RemoveDuplicatesFromSortedArray2;

public class _283_MoveZeroes {
    public static void main(String[] args) {
        var s = new _283_MoveZeroes();

        var arr1 = new int[]{0,1,0,3,12};
        var arr2 = new int[]{0,1,3,12,0};
        s.execute(arr1);
        s.execute(arr2);

        assertEquals(new int[]{1,3,12,0,0}, arr1);
        assertEquals(new int[]{1,3,12,0,0}, arr2);
    }

    public void execute(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
