package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * n rocks (excluding the starting point and the end point), the distance from the i rock to the starting point is
 * d[i], and the distance from the end to the starting point is target. From the starting point to the adjacent
 * rocks at each step until the end point, what is the maximum value of the shortest jump distance when the maximum
 * number of m blocks of rock can be removed?
 *
 *
 * Example
 * Given n=5, m=2, target=25, d=[2,11,14,17,21], return 4.
 *
 * Remove the first stone and the third stone.
 *
 *
 *
 */
public class SkipStone {


    /**
     * @param n: The total number of stones.
     * @param m: The total number of stones you can remove.
     * @param target: The distance from the end to the starting point.
     * @param d: The array that the distance from the i rock to the starting point is d[i].
     * @return: Return the maximum value of the shortest jump distance.
     */
    public static int getDistance(int n, int m, int target, List<Integer> d) {
        // Write your code here.
        if (n == 0 || n == m) {
            return target;
        }

        List<Integer> distance = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            if (i == 0) {
                distance.add(d.get(i));
            } else if (i == d.size() - 1) {
                distance.add(target - d.get(i));
            } else {
                distance.add(d.get(i) - d.get(i - 1));
            }
        }

        return getDistance(n, m, distance);

    }

    private static int getDistance(int n, int m, List<Integer> distance) {
        if (m == 0) {
            return Collections.min(distance);
        }
        mergeList(distance);
        return getDistance(n, m - 1, distance);
    }

    private static void mergeList(List<Integer> distance) {

        int min = Collections.min(distance);
        int minIndex = distance.indexOf(min);
        if (minIndex != distance.size() - 1) {
            min = distance.remove(minIndex);
            int rightOfMin = distance.remove(minIndex);
            distance.add(minIndex, min + rightOfMin);
        } else {
            min = distance.remove(distance.size() - 1);
            int leftOfMin = distance.remove(distance.size() - 1);
            distance.add(distance.size(), min + leftOfMin);
        }

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(11);
        list.add(14);
        list.add(17);
        list.add(21);

        System.out.println(getDistance(5, 2, 25, list));
    }

}
