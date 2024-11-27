package problems.binary_search;

import static util.Assertions.assertEquals;

/**
 * 35. Search Insert Position
 */
public class _35_SearchInsertPosition {

    public static void main(String[] args) {
        var s = new _35_SearchInsertPosition();
        assertEquals(1, s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(1, s.searchInsert(new int[]{1, 3}, 2));
        assertEquals(3, s.searchInsert(new int[]{3, 5, 7, 9, 10}, 8));
        assertEquals(4, s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(2, s.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
