package easy;


/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null || haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }
        int hayLen = haystack.length();
        int neeLen = needle.length();
        char[] hayArr = haystack.toCharArray();
        char[] neeArr = needle.toCharArray();
        for (int i = 0; i < hayLen - neeLen + 1; i++) {
            if (hayArr[i] == neeArr[0]) {
                for (int j = 0; j < neeLen; j++) {
                    if (hayArr[i + j] != neeArr[j]) {
                        break;
                    }
                    if (j == neeLen - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("a", "a"));
    }

}
