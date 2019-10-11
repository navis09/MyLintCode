package easy.string;

/**
 * CountAndSay
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * @author jinxin
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String res = "1";
        if (n < 1) {
            return "";
        }
        while (n > 1) {
            res = countSay(res);
            n--;
        }
        return res;

    }

    public String countSay(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char letter = s.charAt(0);
        int num = 1;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (letter == c) {
                num++;
            } else {
                sb.append(num);
                sb.append(letter);
                num = 1;
                letter = c;
            }
        }
        sb.append(num);
        sb.append(letter);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countSay("1"));
        System.out.println(new CountAndSay().countSay("11"));
        System.out.println(new CountAndSay().countSay("21"));
        System.out.println(new CountAndSay().countSay("1211"));

        System.out.println(new CountAndSay().countAndSay(5));
    }

}
