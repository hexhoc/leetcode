package top_interview_150.sliding_window;

import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        var s = new LongestSubstringWithoutRepeatingCharacter();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        int result = 1;

        for (int i = 0; i < s.length(); i++) {
            int c = 1;
            var h = new HashSet<Character>();
            h.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (h.contains(s.charAt(j))) {
                    break;
                }
                h.add(s.charAt(j));
                c++;
            }

            if (c > result)
                result = c;
        }

        return result;
    }

}
