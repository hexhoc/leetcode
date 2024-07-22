package problems.arrays;

import static util.Assertions.assertEquals;

import java.util.Arrays;

/*
169. Majority Element
Easy
 */
public class _169_MajorityElement {

    public static void main(String[] args) {
        var s = new _169_MajorityElement();
        assertEquals(2, s.execute(new int[]{2,2,1,1,1,2,2}));
        assertEquals(1, s.execute(new int[]{1,1,1,1}));
        assertEquals(5, s.execute(new int[]{6,5,5}));
    }

    public int execute(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
