package top_interview_150.two_pointer;

import javax.xml.stream.events.Characters;

/**
 * 125. Valid Palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        var s = new ValidPalindrome();
        System.out.println(s.isPalindrome("0P"));
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left <= right) {
            while (left < s.length()-1 && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }

            while (right > 0 && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
