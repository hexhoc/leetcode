package arrays.inplace;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int result = RemoveElement.execute(nums, 3);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public static int execute(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }

            nums[k] = nums[i];
            k++;
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        return k;
    }
}
