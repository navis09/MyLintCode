package easy;

/**
 * LongestCommonPrefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    StringBuilder prefix = new StringBuilder();
    if (strs == null || strs.length == 0) {
      return prefix.toString();
    }
    if (strs.length == 1) {
      return strs[0];
    }
    String first = strs[0];
    for (int i = 0; i < first.length(); i++) {
      char temp = first.charAt(i);
      for (int j = 1; j < strs.length; j++) {
        String sub = strs[j];
        if (sub.length() <= i || sub.charAt(i) != temp) {
          return prefix.toString();
        }
      }
      prefix.append(temp);
    }
    return prefix.toString();

  }

  public static void main(String[] args) {
    String[] strs = {"dog","racecar","car"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
  }

}
