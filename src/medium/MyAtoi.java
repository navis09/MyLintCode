package medium;

/**
 * MyAtoi
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting
 * from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them
 * as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the
 * behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either
 * str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * @author jinxin
 */
public class MyAtoi {

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String thinStr = str.trim();

        if (thinStr.length() == 0) {
            return 0;
        }

        boolean positive = true;
        if (thinStr.charAt(0) == '-') {
            positive = false;
        }

        if (thinStr.charAt(0) == '-' || thinStr.charAt(0) == '+') {
            thinStr = thinStr.substring(1);
        }

        int len = thinStr.length();

        long result = 0;
        for (int i = 0; i < len; i++) {
            char c = thinStr.charAt(i);
            if (c < '0' || c > '9') {
                return (int) result;
            }

            int value = c - '0';
            if (i == 0) {
                if (positive) {
                    result = value;
                } else {
                    result = value * (-1);
                }
            } else {
                if (positive){
                    result = result * 10 + value;
                } else {
                    result = result * 10 - value;
                }
            }

            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) result;
    }


    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("42"));
        System.out.println(new MyAtoi().myAtoi("-42"));
        System.out.println(new MyAtoi().myAtoi("4193 with words"));
        System.out.println(new MyAtoi().myAtoi("words and 987"));
        System.out.println(new MyAtoi().myAtoi("-91283472332"));
        System.out.println(new MyAtoi().myAtoi("+1"));
        System.out.println(new MyAtoi().myAtoi("    "));
        System.out.println(new MyAtoi().myAtoi("    "));
    }
}
