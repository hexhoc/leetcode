package top_interview_150.two_pointer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 15. 3Sum
 */
public class ThreeSum {

    public static void main(String[] args) {
        var s = new ThreeSum();
        System.out.println(s.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result.stream().toList();
    }

}
