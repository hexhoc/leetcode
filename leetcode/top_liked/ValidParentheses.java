package top_liked;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 */

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("())"));
        System.out.println(isValid("()[){}"));
        System.out.println(isValid("()(){}"));
    }

    public static boolean isValid(String s) {
        var valid = true;
        var stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
                continue;
            }

            if (stack.isEmpty()) {
                valid = false;
                break;
            }

            if (stack.peek().equals('(') && s.charAt(i) == ')'
                    || stack.peek().equals('[') && s.charAt(i) == ']'
                    || stack.peek().equals('{') && s.charAt(i) == '}') {
                stack.pop();
            } else {
                valid = false;
                break;
            }
        }

        return valid && stack.isEmpty();
    }
}
