package problems.binary_search;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        var s = new _34_FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(s.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{3,3,3}, 3)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{1}, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        var result = new int[] {-1, -1};
        var index = binarySearch(nums, target);
        if (index >= 0) {
            int left = index -1;
            int right = index + 1;
            while (result[0] < 0 || result[1] < 0) {
                if (result[0] < 0) {
                    if (left < 0) {
                        result[0] = 0;
                    } else if (nums[left] < target) {
                        result[0] = left + 1;
                    }
                }

                if (result[1] < 0) {
                    if (right >= nums.length) {
                        result[1] = nums.length - 1;
                    } else if (nums[right] > target) {
                        result[1] = right - 1;
                    }
                }
                left--;
                right++;
            }
        }
        return result;
    }

    public int binarySearch(int[] nums, int target) {
        var result = -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
