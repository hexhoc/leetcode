package top_interview_150.hashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 4 };
        var indexes = twoSum(arr, 6);
        System.out.println(Arrays.toString(indexes));
    }

    public static int[] twoSum(int[] nums, int target) {
        var diffs = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (diffs.containsKey(nums[i])) {
                result[0] = diffs.get(nums[i]);
                result[1] = i;
            }

            diffs.put(target - nums[i], i);
        }

        return result;
    }
}