package top_interview_150.multidimensional_dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        var s = new LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("xvamadamse"));
        System.out.println(System.currentTimeMillis() - start);
    }

    public String longestPalindrome(String s) {
        var result = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)
                        && j - i >= result.length()) {
                    var sb = new StringBuilder(s.substring(i, j+1));
                    if (sb.toString().equals(sb.reverse().toString())) {
                        result = sb.toString();
                    }
                }
            }
        }

        return result;
    }

        public String old_longestPalindrome(String s) {
        var result = "";
        if (s.length()==1)
            return s;

        Map<Character, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i))) {
                hash.get(s.charAt(i)).add(i);
            } else {
                var indexList = new ArrayList<Integer>();
                indexList.add(i);
                hash.put(s.charAt(i), indexList);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!hash.containsKey(s.charAt(i))) {
                continue;
            }

            var indexes = hash.get(s.charAt(i));
            for (int j = 0; j < indexes.size(); j++) {
                if (result.length() != 0
                        && indexes.get(j) - i < result.length()) {
                    continue;
                }

                var sb = new StringBuilder(s.substring(i, indexes.get(j)+1));
                if (sb.toString().equals(sb.reverse().toString())) {
                    result = sb.toString();
                } else {
                    break;
                }
            }
        }

        return result;
    }

}
