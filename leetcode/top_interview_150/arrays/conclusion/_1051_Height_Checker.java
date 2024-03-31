package top_interview_150.arrays.conclusion;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/* 
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line
in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i]
is the expected height of the i-th student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i]
is the height of the i-th student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.


Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.


Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
*/ 
public class _1051_Height_Checker {
    public static void main(String[] args) {
        var r1 = _1051_Height_Checker.execute(new int[]{1,1,4,2,1,3});
        var r2 = _1051_Height_Checker.execute(new int[]{5,1,2,3,4});
        var r3 = _1051_Height_Checker.execute(new int[]{1,2,3,4,5});
        System.out.println(r1 == 3);
        System.out.println(r2 == 5);
        System.out.println(r3 == 0);
    }

    public static int execute(int[] heights) {
        AtomicInteger count = new AtomicInteger();
        var sorted = IntStream.of(heights).sorted().toArray();
        IntStream.range(0, heights.length).forEach(i -> {
            count.addAndGet(sorted[i] != heights[i] ? 1 : 0);
        });
        return count.get();
    }

}
