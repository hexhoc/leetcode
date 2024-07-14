package problems.binary_search;

import static util.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Stack;

/*
45. Jump Game II
Medium
 */
public class _1306_JumpGame3 {

    public static void main(String[] args) {
        var s = new _1306_JumpGame3();
        assertEquals(true, s.execute(new int[]{4,2,3,0,3,1,2}, 5));
        assertEquals(true, s.execute(new int[]{4,2,3,0,3,1,2}, 0));
        assertEquals(false, s.execute(new int[]{3,0,2,1,2}, 2));
    }

    public boolean execute(int[] arr, int start) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.add(start);
        while(!stack.isEmpty()) {
            var index  = stack.pop();
            if (visited.contains(index)) {
                continue;
            }

            visited.add(index);
            if (arr[index] == 0) {
                return true;
            }
            if (index + arr[index] < arr.length)
                stack.add(index + arr[index]);

            if (index - arr[index]>= 0)
                stack.add(index - arr[index]);
        }

        return false;
    }
}
