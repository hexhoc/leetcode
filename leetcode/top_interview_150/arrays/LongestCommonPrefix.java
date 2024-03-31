package top_interview_150.arrays;

/**
 * 14. Longest Common Prefix
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        var result = longestCommonPrefix(new String[] { "ab", "a" });
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        var result = "";
        boolean maxPrefixFound = false;
        int prefixLength = 1;

        while (!maxPrefixFound) {
            if (prefixLength > strs[0].length()) {
                break;
            }
            var prefix = strs[0].substring(0, prefixLength);
            for (int i = 1; i < strs.length; i++) {
                if (prefixLength > strs[i].length()
                        || !prefix.equals(strs[i].substring(0, prefixLength))) {
                    maxPrefixFound = true;
                    break;
                }
            }
            if (!maxPrefixFound) {
                result = prefix;
            }
            prefixLength++;
        }
        return result;
    }
}
