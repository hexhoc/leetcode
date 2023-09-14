package top_interview_150.sliding_window;

/**
 *
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        var s = new MinimumSizeSubarraySum();
        System.out.println(s.minSubArrayLen(3, new int[]{1,2,3,4,5}));
        System.out.println(s.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(s.minSubArrayLen(4, new int[]{1,4,4})); // 1
    }

    public int minSubArrayLen(int target, int[] nums) {
        int gap = 0;
        boolean found = false;

        while(!found && gap < nums.length) {
            for (int i = 0; i+gap < nums.length; i++) {
                int sum = 0;
                for (int j = i; j <= i+gap; j++) {
                    sum = sum + nums[j];
                }

                if (sum == target) {
                    found = true;
                    break;
                }
            }
            gap++;
        }

        if (!found) {
            return 0;
        }

        return gap;
    }
}
