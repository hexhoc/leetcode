package top_interview_150.two_pointer;

/**
 * 392. Is Subsequence
 * Easy
 */
public class IsSubsequence {

    public static void main(String[] args) {
        var s = new IsSubsequence();
        System.out.println(s.isSubsequence("b", "abbc"));
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int k = 0;
        for (int i = 0;i < t.length() && k < s.length(); i++) {
            if (t.charAt(i) == s.charAt(k)) {
                k++;
            }
        }

        return k == s.length();
    }
}
