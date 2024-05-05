package problems.arrays.conclusion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        var s = new _448_Find_All_Numbers_Disappeared_in_an_Array();
        var result1 = s.execute(new int[]{1,1});
        var result2 = s.execute(new int[]{4,3,2,7,8,2,3,1});
        var result3 = s.execute(new int[]{2,2});
        System.out.println(result1.equals(List.of(2)));
        System.out.println(result2.equals(List.of(5,6)));
        System.out.println(result3.equals(List.of(1)));
    }

    public List<Integer> execute(int[] nums) {
        var set = IntStream.range(1, nums.length + 1).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            set.remove(num);
        }

        return set.stream().toList();
    }

}
