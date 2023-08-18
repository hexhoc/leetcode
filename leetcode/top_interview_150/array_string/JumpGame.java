package top_interview_150.array_string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
55. Jump Game
Medium
 */
public class JumpGame {

    public static void main(String[] args) {
        var s = new JumpGame();
        System.out.println(s.canJump(new int[]{2,5,0,0}));
        System.out.println(s.canJump(new int[]{0}));
        System.out.println(s.canJump(new int[]{2,3,1,1,4}));
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public boolean canJumpRecurse(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return checkPath(nums, 0, new HashSet<>());
    }

    public boolean checkPath(int[] nums, int i, Set<Integer> visited) {
        visited.add(i);

        var jumpLength = nums[i];
        for (int k = jumpLength; k > 0; k--) {
            int nextIndex = i + k;
            if (nextIndex >= nums.length-1) {
                return true;
            }
            if (!visited.contains(nextIndex)) {
                if (checkPath(nums, nextIndex, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

}
