package arrays.conclusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
EASY
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all 
the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]
*/

public class _448_Find_All_Numbers_Disappeared_in_an_Array {

    public static void main(String[] args) {
        _448_Find_All_Numbers_Disappeared_in_an_Array.execute(new int[]{1,1});
        _448_Find_All_Numbers_Disappeared_in_an_Array.execute(new int[]{4,3,2,7,8,2,3,1});
        _448_Find_All_Numbers_Disappeared_in_an_Array.execute(new int[]{2,2});
    }

    public static List<Integer> execute(int[] nums) {
        var numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        var result = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numsSet.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

}
