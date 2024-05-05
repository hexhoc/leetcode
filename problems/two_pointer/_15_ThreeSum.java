package problems.two_pointer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 15. 3Sum
 * Medium
 */
public class _15_ThreeSum {

    public static void main(String[] args) {
        var s = new _15_ThreeSum();
        System.out.println(s.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.stream().toList();
    }

}
