package problems.arrays.conclusion;

import static util.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

public class _414_ThirdMaximumNumber {

    public static void main(String[] args) {
        var s = new _414_ThirdMaximumNumber();

        assertEquals(1, s.execute(new int[] { 1,2,3 }));
        assertEquals(2, s.execute(new int[] { 1,2 }));
        assertEquals(1, s.execute(new int[] { 2,2,3,1 }));
        assertEquals(6, s.execute(new int[] { 5,5,6 }));
    }

    public int execute(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i+1]) {
                count++;
            }
            if (count == 3) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    public int executeStream(int[] nums) {
        var list = Arrays.stream(nums)
            .boxed()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .toList();
        return list.size() < 3 ? list.get(0) : list.get(2);
    }
}