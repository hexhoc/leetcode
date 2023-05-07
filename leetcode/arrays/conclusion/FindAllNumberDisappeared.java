package arrays.conclusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all 
the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]
*/

public class FindAllNumberDisappeared {

    public static void main(String[] args) {
        FindAllNumberDisappeared.execute(new int[]{4,3,2,7,8,2,3,1});
        FindAllNumberDisappeared.execute(new int[]{2,2});
        FindAllNumberDisappeared.execute(new int[]{1,1});
    }

    public static List<Integer> execute(int[] nums) {
        return executeWithoutSet(nums);
    }

    public static List<Integer> executeWithSet(int[] nums) {
        Set<Integer> setNums = IntStream.of(nums).boxed().collect(Collectors.toSet());
        List<Integer> missNums = new ArrayList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            if (!setNums.contains(i)) {
                missNums.add(i);
            }
        }
        
        return missNums;
    }

    public static List<Integer> executeWithoutSet(int[] nums) {

        boolean[] boolArr = new boolean[nums.length+1];
        List<Integer> missNums = new ArrayList<>();

        for (int n : nums) {
            boolArr[n] = true;
        }

        for (int i = 1; i < boolArr.length; i++) {
            if (!boolArr[i]) {
                missNums.add(i);
            }
        }

        return missNums;
    }
}
