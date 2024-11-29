package problems.binary_search;

import static util.Assertions.assertEquals;

public class _704_BinarySearch {

    public static void main(String[] args) {
        var s = new _704_BinarySearch();
        assertEquals(4, s.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, s.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public int search(int[] nums, int target) {
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
        return -1;
    }
}
