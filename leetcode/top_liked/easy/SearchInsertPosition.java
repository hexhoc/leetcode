package top_liked.easy;

/**
 * 35. Search Insert Position
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        var s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1,3,5,7}, 6));
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