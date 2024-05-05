package problems.arrays.inplace;

import java.util.Arrays;

/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all 
the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:

Input: nums = [0]
Output: [0]
*/

// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.

public class _905_Sort_Array_By_Parity {
    public static void main(String[] args) {
        int[] nums = _905_Sort_Array_By_Parity.execute(new int[]{3,1,2,4});
        System.out.println(Arrays.toString(nums));

    }

    public static int[] execute(int[] nums) {
        return executeQuickSort(nums);
    }

    public static int[] executeBubbleSort(int[] nums) {
        boolean doSort = true;

        while(doSort) {
            doSort = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i-1] % 2 != 0 && nums[i] % 2 == 0) {
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                    doSort = true;
                }
            }
        }

        return nums;
    }

    public static int[] executeQuickSort(int[] nums) {
        return Arrays.stream(nums)
        .boxed()
        .sorted((a, b) -> Integer.compare(a%2, b%2))
        .mapToInt(i->i)
        .toArray();
    }


}
