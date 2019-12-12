package medium;

/**
 * LongestPalindromicSubstring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author jinxin
 */
public class LongestPalindromicSubstring {

    /**
     * 暴力解法优化
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        while (len > 0) {
            for (int left = 0; left < arr.length - len + 1; left++) {
                if (isPalindrome(arr, left, left + len - 1)) {
                    return s.substring(left, left + len);
                }
            }
            len--;
        }
        return s.substring(0, 1);
    }

    private boolean isPalindrome(char[] arr, int first, int last) {
        while(first < last) {
            if (arr[first] != arr[last]) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCerter(s, i, i);
            int len2 = expandAroundCerter(s, i, i + 1);
            int length = Math.max(len1, len2);

            if (length > maxLen) {
                maxLen = length;
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCerter(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left++;
            right--;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbba"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("eabcb"));
    }
}
