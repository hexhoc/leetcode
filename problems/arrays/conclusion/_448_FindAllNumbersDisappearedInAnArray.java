package problems.arrays.conclusion;

import static util.Assertions.assertEquals;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _448_FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        var s = new _448_FindAllNumbersDisappearedInAnArray();

        assertEquals(List.of(2), s.execute(new int[]{1, 1}));
        assertEquals(List.of(5, 6), s.execute(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        assertEquals(List.of(1), s.execute(new int[]{2, 2}));
    }

    public List<Integer> execute(int[] nums) {
        var set = IntStream.range(1, nums.length + 1).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            set.remove(num);
        }

        return set.stream().toList();
    }

}
