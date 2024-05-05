package problems.arrays.searching;

/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true
*/

public class _941_ValidMountainArray {
    public static void main(String[] args) {
        // ValidMountainArray.execute(new int[] { 2,1 });
        // ValidMountainArray.execute(new int[] { 0, 2, 3, 3, 5, 2, 1, 0 });
        _941_ValidMountainArray.execute(new int[] { 0, 2, 3, 4, 5, 2, 1, 0 });
    }

    public static boolean execute(int[] nums) {
        int rise = 0;
        int decent = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                rise++;
            } else {
                break;
            }
        }

        for (int i = rise+1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                decent++;
            } else {
                break;
            }
        }

        return nums.length == (rise+decent+1) && rise > 0 && decent > 0;
    }
}
