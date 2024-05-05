package problems.two_pointer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * Medium
 */
public class _167_TwoSum2 {

    public static void main(String[] args) {
        var s = new _167_TwoSum2();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{-1,0}, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (diffMap.containsKey(numbers[i])) {
                result[0] = diffMap.get(numbers[i])+1;
                result[1] = i+1;
                break;
            }
            diffMap.put(target - numbers[i], i);
        }

        return result;
    }
}
