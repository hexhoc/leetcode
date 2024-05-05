package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * TODO: Повторить, сложно.
 * for input n = 2
 * 								   	(0, 0, '')
 * 								 	    |
 * 									(1, 0, '(')
 * 								   /           \
 * 							(2, 0, '((')      (1, 1, '()')
 * 							   /                 \
 * 						(2, 1, '(()')           (2, 1, '()(')
 * 						   /                       \
 * 					(2, 2, '(())')                (2, 2, '()()')
 * 						      |	                             |
 * 					res.append('(())')             res.append('()()')
 */
public class _22_GenerateParentheses {

    public static void main(String[] args) {
        var s = new _22_GenerateParentheses();
        System.out.println(s.generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(result, "", 0, 0, n);
        return result;
    }

    public void recurse(List<String> result, String s, int left, int right, int n) {
        if (s.length() == n*2) {
            result.add(s);
            return;
        }

        if (left < n) {
            recurse(result, s+"(", left+1, right, n);
        }

        if (right < left) {
            recurse(result, s+")", left, right+1, n);
        }
    }
}
