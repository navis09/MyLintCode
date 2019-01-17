package easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 *
 * The characters in string A and B are all Upper Case letters.
 *
 * Example
 * For A = "ABCD", B = "ACD", return true.
 *
 * For A = "ABCD", B = "AABC", return false.
 *
 */
public class CompareStrings {

    public static void main(String[] args) {
        System.out.println(new CompareStrings().compareStrings("AAAAAAAAAAAABBBBBCDD", "ABCDD"));
    }

    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A.length() == 0 || A.length() < B.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (!map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), 1);
            } else {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i)) || map.get(B.charAt(i)) <= 0) {
                return false;
            } else {
                map.put(B.charAt(i), map.get(B.charAt(i)) - 1);
            }
        }
        return true;
    }
}
