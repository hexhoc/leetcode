package problems.arrays;

import static util.Assertions.assertEquals;

import java.util.Map;

/**
 * 13. Roman to Integer
 * Easy
 */
public class _13_RomanToInteger {
    public static void main(String[] args) {
        var s = new _13_RomanToInteger();
        assertEquals(3, s.execute("III"));
        assertEquals(58, s.execute("LVIII"));
        assertEquals(1994, s.execute("MCMXCIV"));
    }

    public int execute(String s) {
        int result = 0;
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

        var chars = s.toCharArray();
        int prevValue = Integer.MIN_VALUE;
        for (int i = chars.length-1; i >= 0; i--) {
            int curValue = map.get(chars[i]);
            if (curValue < prevValue) {
                result = result - curValue;
            } else {
                result = result + curValue;
            }
            prevValue = curValue;
        }
        return result;
    }
}