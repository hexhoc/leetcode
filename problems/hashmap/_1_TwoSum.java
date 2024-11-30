package problems.hashmap;

import static util.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        var s = new _1_TwoSum();
        assertEquals(new int[]{1,2}, s.twoSum(new int[] { 3, 2, 4 }, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (diffMap.containsKey(nums[i])) {
                result[0] = diffMap.get(nums[i]);
                result[1] = i;
                break;
            }
            diffMap.put(target - nums[i], i);
        }
        return result;
    }
}