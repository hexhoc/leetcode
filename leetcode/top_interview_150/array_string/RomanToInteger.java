package top_interview_150.array_string;

import java.util.Map;

/**
 * 13. Roman to Integer
 */
public class RomanToInteger {
    public static void main(String[] args) {
        var result = romanToInt("XXIX");
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        var result = 0;
        var romanMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        result += romanMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (romanMap.get(s.charAt(i - 1)) >= romanMap.get(s.charAt(i))) {
                result += romanMap.get(s.charAt(i));
            } else {
                result -= romanMap.get(s.charAt(i - 1));
                result += romanMap.get(s.charAt(i)) - romanMap.get(s.charAt(i - 1));
            }
        }

        return result;
    }

}
