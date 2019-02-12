package easy;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * You are standing at position 0 on an infinite number line. There is a goal at position target.
 *
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 *
 * Return the minimum number of steps required to reach the destination.
 *
 * Example
 * Example1
 *
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * Example2
 *
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 *
 */
public class ReachNumber {


    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public int reachNumber(int target) {
        // Write your code here
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k%2;
    }

    public static void main(String[] args) {
        System.out.println(new ReachNumber().reachNumber(9));
    }

}
