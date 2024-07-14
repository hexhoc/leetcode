package problems.arrays;

import static util.Assertions.assertEquals;

/*
55. Jump Game
Medium
rating: 1
 */
public class _55_JumpGame {

    public static void main(String[] args) {
        var s = new _55_JumpGame();
        assertEquals(true, s.execute(new int[]{2,3,1,1,4}));
        assertEquals(false, s.execute(new int[]{3,2,1,0,4}));
        assertEquals(true, s.execute(new int[]{2,5,0,0}));
        assertEquals(true, s.execute(new int[]{0}));
        assertEquals(true, s.execute(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
        assertEquals(true, s.execute(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

    public boolean execute(int[] nums) {
        int jumpCounter = 0;
        for (int num : nums) {
            if (jumpCounter < 0)
                return false;

            if (num > jumpCounter) {
                jumpCounter = num;
            }
            jumpCounter--;
        }
        return true;
//        int j = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (j < i) {
//                return false;
//            }
//
//            if ((i + nums[i]) > j) {
//                j = i + nums[i];
//            }
//        }
//        return true;
    }
}