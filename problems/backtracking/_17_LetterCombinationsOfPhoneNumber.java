package problems.backtracking;

import static util.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * easy
 */
public class _17_LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        var s = new _17_LetterCombinationsOfPhoneNumber();
        assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), s.letterCombinations("23"));
        assertEquals(List.of("a", "b", "c"), s.letterCombinations("2"));
    }

    public static Map<Integer, String> buttons = Map.of(
        2, "abc",
        3, "def",
        4, "ghi",
        5, "jkl",
        6, "mno",
        7, "pqrs",
        8, "tuv",
        9, "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        addCombination(digits, 0, combinations, "");
        return combinations;
    }

    private void addCombination(String digits, int digitIndex, List<String> combinations, String combination) {
        if (digits.length() == digitIndex) {
            combinations.add(combination);
            return;
        }
        int num = Integer.parseInt(digits.substring(digitIndex, digitIndex + 1));
        var letters = buttons.getOrDefault(num, "");
        for (int i = 0; i < letters.length(); i++) {
            var letter = letters.substring(i, i + 1);
            addCombination(digits, digitIndex + 1, combinations, combination + letter);
        }
    }
}
