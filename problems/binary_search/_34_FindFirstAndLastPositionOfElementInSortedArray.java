package problems.binary_search;

import static util.Assertions.assertEquals;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        var s = new _34_FindFirstAndLastPositionOfElementInSortedArray();
        assertEquals(new int[]{-1, -1}, s.searchRange(new int[]{2,2}, 3));
        assertEquals(new int[]{-1, -1}, s.searchRange(new int[]{}, 0));
        assertEquals(new int[]{3, 4}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertEquals(new int[]{0, 2}, s.searchRange(new int[]{3, 3, 3}, 3));
        assertEquals(new int[]{0, 0}, s.searchRange(new int[]{1}, 1));
    }

    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target);
        if (i == -1) {
            return new int[]{-1, -1};
        }

        int min = i;
        int max = i;
        int step = 1;
        boolean found = true;
        while (found) {
            found = false;
            if (i - step >= 0 && nums[i - step] == target) {
                min = i - step;
                found = true;
            }

            if (i + step < nums.length && nums[i + step] == target) {
                max = i + step;
                found = true;
            }
            step++;
        }

        return new int[]{min, max};
    }

    private int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }
}
