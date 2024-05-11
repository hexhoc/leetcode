package problems.arrays.inplace;

import static util.Assertions.assertEquals;

public class _1299_ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        var s = new _1299_ReplaceElementsWithGreatestElementOnRightSide();

        assertEquals(new int[]{18,6,6,6,1,-1}, s.execute(new int[]{17,18,5,4,6,1}));
        assertEquals(new int[]{18,6,6,6,1,-1}, s.execute(new int[]{17,16,5,4,3,1}));
    }

    public static int[] execute(int[] nums) {
        int max = nums[nums.length - 1];
        nums[nums.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                var temp = nums[i];
                nums[i] = max;
                max = temp;
                continue;
            }
            nums[i] = max;
        }
        return nums;
    }
}