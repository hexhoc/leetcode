package problems.backtracking;

import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class _17_LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        var s = new _17_LetterCombinationsOfPhoneNumber();
        System.out.println(s.letterCombinations("23"));
    }

    public static Map<Integer, String> buttons = Map.of(
            2, "abc",
            3,"def",
            4,"ghi",
            5,"jkl",
            6,"mno",
            7,"pqrs",
            8,"tuv",
            9,"wxyz"
    );

    public List<String> letterCombinations(String digits) {

        var total = new StringBuilder();
        var prefix = new StringBuilder();
        collectLetterCombination(total, prefix, digits, 0);
        return List.of(total.toString().split("_"));
    }

    private void collectLetterCombination(StringBuilder total, StringBuilder prefix, String digits, int i) {
        if (i >= digits.length()) {
            total.append(prefix.toString()).append("_");
            return;
        }
        int num = Integer.parseInt(digits.substring(i, i+1));
        var chars = buttons.get(num);
        for (int j = 0; j < chars.length(); j++) {
            prefix.append(chars.substring(j,j+1));
            collectLetterCombination(total, prefix, digits, i+1);
            prefix.delete(prefix.length()-1, prefix.length());
        }
    }

}
