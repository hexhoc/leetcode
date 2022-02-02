package arrays.inplace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = SortArrayByParity.executeQuickSort(new int[]{3,1,2,4});
        System.out.println(Arrays.toString(nums));


    }

    public static int[] executeBubbleSort(int[] nums) {
        
        boolean doSort = true;

        while (doSort) {
            doSort = false;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] % 2 != 0 && nums[i+1] % 2 == 0) {
                    doSort = true;
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        return nums;


    }

    public static int[] executeQuickSort(int[] nums) {

        return Arrays.stream(nums)
        .boxed()
        .sorted((a, b) -> Integer.compare(a%2, b%2))
        .mapToInt(i->i)
        .toArray();
    }

    public static int[] execute(int[] nums) {
        boolean doSort = true;

        while (doSort) {
            doSort = false;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] % 2 != 0 && nums[i+1] % 2 == 0) {
                    doSort = true;
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        return nums;
    }

}
