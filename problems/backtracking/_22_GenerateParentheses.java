package problems.backtracking;

import static util.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * for input n = 3
 *  \    /  \    /  \  /\/  \/\/\/
 *   \  /    \/\/    \/
 *    \/
 */
public class _22_GenerateParentheses {

    public static void main(String[] args) {
        var s = new _22_GenerateParentheses();
        assertEquals(List.of("((()))", "(()())", "(())()", "()(())", "()()()"), s.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        recurse(result, "", 0, 0, n);
        return result;
    }

    private void recurse(List<String> result, String s, int left, int right, int n) {
        if (s.length() == n*2) {
            result.add(s);
            return;
        }
        if (left < n) {
            recurse(result, s + "(", left + 1, right, n);
        }
        if (right < left) {
            recurse(result, s + ")", left, right+1, n);
        }
    }
}
