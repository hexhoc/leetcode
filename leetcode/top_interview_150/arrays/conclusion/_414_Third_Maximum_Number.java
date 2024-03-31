package top_interview_150.arrays.conclusion;

import java.util.*;
import java.util.stream.IntStream;

/*
EASY

Given an integer array nums, return the third distinct maximum number in this array. 
If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 */
public class _414_Third_Maximum_Number {

    public static void main(String[] args) {
        var s = new _414_Third_Maximum_Number();
        Integer result;
        result = s.thirdMax(new int[] { 1,2,3});
        System.out.println(result);
        result = s.thirdMax(new int[] { 1,2 });
        System.out.println(result);
        result = s.thirdMax(new int[] { 2,2,3,1 });
        System.out.println(result);
        result = s.thirdMax(new int[] { 5, 5, 6 });
        System.out.println(result);
    }

    public int thirdMax_stream(int[] nums) {
        var sortedList = IntStream.of(nums)
            .boxed()
            .distinct()
            .sorted()
            .toList();
        return sortedList.get(Math.max(sortedList.size()-3, 0));
    }

    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        var sortedArr = set.toArray(Integer[]::new);
        return sortedArr[Math.max(sortedArr.length-3, 0)];
    }

}