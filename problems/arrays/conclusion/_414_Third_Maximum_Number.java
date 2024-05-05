package problems.arrays.conclusion;

import java.util.*;
import java.util.stream.IntStream;

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