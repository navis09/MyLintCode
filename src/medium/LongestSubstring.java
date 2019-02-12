package medium;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Challenge
 * O(n) time
 *
 */
public class LongestSubstring {


    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s.length() <= 1) {
            return s.length();
        }
        // char -> latest index
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int len = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                len = Math.min(len + 1, i - map.get(arr[i]));
            } else {
                len++;
            }
            map.put(arr[i], i);
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("an++--viaj"));
    }
}
