package easy.string;


/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String trimStr = s.replaceAll("[^a-zA-Z0-9]", "");
        int len = trimStr.length();
        char[] strArr = trimStr.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (Character.toLowerCase(strArr[i]) != Character.toLowerCase(strArr[len - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("racecar"));
    }
}
