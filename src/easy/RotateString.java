package easy;

public class RotateString {

    /**
     * Given a string and an offset, rotate string by offset. (rotate from left to right)
     *
     * Given "abcdefg".
     *
     * offset=0 => "abcdefg"
     * offset=1 => "gabcdef"
     * offset=2 => "fgabcde"
     * offset=3 => "efgabcd"
     *
     * @param str
     * @param offset
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length < 2) {
            return;
        }
        int rotate = offset % str.length;
        for (int i = 0; i < rotate; i++) {
            rotateOnce(str);
        }
    }

    private void rotateOnce(char[] str) {
        char temp = str[str.length - 1];
        for (int i = str.length - 1; i > 0; i--) {
            str[i] = str[i - 1];
        }
        str[0] = temp;
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a','b','c'};
        System.out.println(str);
        new RotateString().rotateOnce(str);
        System.out.println(str);
    }
}
