package arrays.conclusion;

/*
Given a binary array, find the maximum number of consecutive ones in this array if you can flip at most one 0.
Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive ones.
    After flipping, the maximum number of consecutive 1s is 4.
Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

import java.util.TreeSet;

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        int result = MaxConsecutiveOnes2.execute(new int[] { 1, 0, 1, 1, 0 });

    }

    public static int execute(int[] nums) {
        TreeSet<Integer> maxConsecutive = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int maxFlip = 1;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    if (maxFlip == 0) {
                        break;
                    }
                    maxFlip--;
                }
                sum++;
            }
            maxConsecutive.add(sum);
        }

        return maxConsecutive.last();
    }

}
