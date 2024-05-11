package problems.arrays.inplace;

import static util.Assertions.assertEquals;

public class _905_SortArrayByParity {
    public static void main(String[] args) {
        var s = new _905_SortArrayByParity();
        int[] nums = s.execute(new int[]{3,1,2,4});
        assertEquals(new int[]{2,4,3,1}, nums);
    }

    public static int[] execute(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                k++;
                var temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }

        return nums;
    }
}
