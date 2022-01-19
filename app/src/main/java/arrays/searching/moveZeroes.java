package arrays.searching;

import java.util.LinkedList;

public class moveZeroes {
    public static void main(String[] args) {

        moveZeroes.execute(new int[]{0,1,0,3,12});
        moveZeroes.execute(new int[]{0,1,3,12,0});
    }

    public static void execute(int[] nums) {

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         for (int j = i; j < nums.length; j++) {
        //             if (nums[j] != 0) {
        //                 int temp = nums[j];
        //                 nums[j] = nums[i];
        //                 nums[i] = temp;
        //                 break;
        //             }
        //         }
        //     }
        // }

        int[] newNums = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                newNums[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}
