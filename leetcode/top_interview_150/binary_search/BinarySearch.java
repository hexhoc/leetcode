package top_interview_150.binary_search;

public class BinarySearch {

    public static void main(String[] args) {
        var s = new BinarySearch();
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 13));
        System.out.println(s.search(new int[]{1,2,3,4,5,6,7}, 1));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 2));
    }

    public int search(int[] nums, int target) {
        var result = -1;
        var left = 0;
        var right = nums.length-1;

        while(left <= right) {
            var mid = (right + left) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                mid--;
                right = mid;
            } else {
                mid++;
                left = mid;
            }
        }

        return result;
    }
}
