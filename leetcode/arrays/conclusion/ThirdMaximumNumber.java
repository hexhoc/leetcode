package arrays.conclusion;

import java.util.*;
import java.util.stream.IntStream;

/**
Given an integer array nums, return the third distinct maximum number in this array. 
If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        ThirdMaximumNumber.execute(new int[] { 5, 5, 6 });
    }

    public static int execute(int[] nums) {
        List<Integer> maxList =new ArrayList<>();

        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    int swap = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = swap;
                    done = false;
                }
            }
        }

        Integer prevNum = null;
        int thirdMaxNum = nums[0];
        int counter = 1;
        for (int i = 0; i < nums.length; i++) {
            thirdMaxNum = nums[i];
            if (counter > 3) {
                break;
            }
            if (prevNum == null || prevNum != nums[i]) {
                counter++;
            }

            prevNum = nums[i];
        }

        return thirdMaxNum;
    }

    public static int executeUsingSet(int[] nums) {
        var numsList = IntStream.of(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct().toList();

        if (numsList.size() >= 3) {
            return numsList.get(2);
        }

        return numsList.get(0);
    }

}