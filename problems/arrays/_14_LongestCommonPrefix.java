package problems.arrays;

import static util.Assertions.assertEquals;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * easy
 * MUST LEARN
 */
public class _14_LongestCommonPrefix {

    public static void main(String[] args) {
        var s = new _14_LongestCommonPrefix();
        assertEquals("a", s.execute(new String[] { "ab", "a" }));
        assertEquals("fl", s.execute(new String[] { "flower","flow","flight" }));
        assertEquals("fl", s.execute(new String[] { "flower","flight","flow" }));
        assertEquals("", s.execute(new String[] { "dog","racecar","car" }));
        assertEquals("ab", s.execute(new String[] { "abab","abc","aba" }));
    }

    public String execute(String[] strs) {
        Arrays.sort(strs, String::compareTo);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int lastIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            lastIndex = i + 1;
        }

        return s1.substring(0, lastIndex);
    }
}