package medium;

import java.util.*;

/**
 * Ugly number is a number that only have factors 2, 3 and 5.
 *
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */
public class UglyNumber {

    public int uglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 1;

        TreeSet<Integer> uglySet = new TreeSet();
        uglySet.add(1);
        int maxDivideTwo = Integer.MAX_VALUE / 2;
        int maxDivideThree = Integer.MAX_VALUE / 3;
        int maxDivideFive = Integer.MAX_VALUE / 5;
        while(n != 0) {
            result = uglySet.pollFirst();
            if (result <= maxDivideTwo) {
                uglySet.add(result * 2);
            }
            if (result <= maxDivideThree) {
                uglySet.add(result * 3);
            }
            if (result <= maxDivideFive) {
                uglySet.add(result * 5);
            }
            n--;
        }

        return result;
    }

    public static void printUglyList(int index) {
        UglyNumber uglyNumber = new UglyNumber();
        for (int i = 1; i <= index; i++) {
            System.out.println(uglyNumber.uglyNumber(i));
        }
    }

    public static void main(String[] args) {
        printUglyList(1665);
    }

}
