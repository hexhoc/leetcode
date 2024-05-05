package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class _39_CombinationSum {

    public static void main(String[] args) {
        var s = new _39_CombinationSum();
        s.combinationSum(new int[] {2,3,5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursiveSum(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public void recursiveSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> nums, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(nums));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            nums.add(candidates[i]);
            recursiveSum(candidates, target - candidates[i], result, nums, i);
            nums.remove(nums.size()-1);
        }
    }

}
