package problems.binary_search;

import static util.Assertions.assertEquals;

/**
 * 33. Search in Rotated Sorted Array
 */
public class _33_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        var s = new _33_SearchInRotatedSortedArray();
        assertEquals(0, s.search(new int[]{5, 1, 3}, 5));
        assertEquals(0, s.search(new int[]{3, 5, 1}, 3));
        assertEquals(4, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(2, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        assertEquals(-1, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, s.search(new int[]{1}, 0));
    }

    public int search(int[] nums, int target) {
        var pivotIndex = searchPivot(nums);
        int left = 0;
        int right = 0;
        if (target >= nums[0]) {
            left = 0;
            right = pivotIndex;
        } else {
            left = pivotIndex;
            right = nums.length-1;
        }

        return binarySearch(nums, target, left, right);

    }

    public int searchPivot(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (mid > left && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[mid] <= nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums.length-1;
    }

    public int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) /2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
