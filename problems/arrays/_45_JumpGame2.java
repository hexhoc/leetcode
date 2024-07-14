package problems.arrays;

import static util.Assertions.assertEquals;

/*
45. Jump Game II
Medium
 */
public class _45_JumpGame2 {

    public static void main(String[] args) {
        var s = new _45_JumpGame2();
        assertEquals(1, s.execute(new int[]{1,2}));
        assertEquals(0, s.execute(new int[]{3,2,1,0,4}));
        assertEquals(2, s.execute(new int[]{2,3,1,1,4}));
        assertEquals(2, s.execute(new int[]{2,5,0,0}));
        assertEquals(1, s.execute(new int[]{3,2,1}));
        assertEquals(0, s.execute(new int[]{0}));
        assertEquals(0, s.execute(new int[]{0,1}));
        assertEquals(5, s.execute(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
        assertEquals(3, s.execute(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));

    }

    public int execute(int[] nums) {
        int totalJump = 0;
        int maxPosition = 0;
        int newPosition = 0;
        for (int i = 0; i < nums.length-1; i++) {
            // find new max position
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == newPosition) {
                // we cannot jump anywhere
                if (maxPosition == newPosition) {
                    return 0;
                }
                // set new max position and jump
                newPosition = maxPosition;
                totalJump++;
            }
        }

        return totalJump;
    }
}
