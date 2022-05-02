package arrays.conclusion;

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
