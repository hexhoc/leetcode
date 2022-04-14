package arrays.conclusion;

import java.util.Comparator;
import java.util.HashSet;

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        int result = MaxConsecutiveOnes2.execute(new int[] { 1, 0, 1, 1, 0 });
        
    }

    public static int execute(int[] nums) {
        int maxConsecutive = 1;
        int maxFlip = 1;
        HashSet<Integer> setOfMax = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == 1) {
                maxConsecutive++;
            } else {
                if (maxFlip > 0) {
                    current = 1;
                    maxFlip--;
                }
            }

            if (i == nums.length-1 || (current == 0 && maxFlip == 0)) {
                setOfMax.add(maxConsecutive);
                maxFlip = 1;
            }
        }

        return setOfMax.stream().max(Comparator.naturalOrder()).get();
    }

}
