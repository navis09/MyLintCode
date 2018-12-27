package easy;

import java.util.ArrayList;
import java.util.List;


/**
 * The “Narcissistic numbers”, are n digit numbers where the sum of all the nth power of their digits is equal to the number.
 *
 * So, 153 is a narcissistic number because 1^3 + 5^3 + 3^3 = 153.
 *
 * Now given N, find all Narcissistic numbers that are N digit length
 */
public class NarcissisticNumber {

    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            return list;
        }

        int small = (int)Math.pow(10, n - 1);
        int large = (int)Math.pow(10, n);

        for (int i = small; i < large; i++) {
            int num = i;
            int result = 0;
            while (num != 0) {
                int digit = num % 10;
                result += Math.pow(digit, n);
                num /= 10;
            }
            if (result == i) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new NarcissisticNumber().getNarcissisticNumbers(3));
    }

}
