package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
 * The list pair has k operator and each operator has two integer A[i].x, A[i].y means
 * that you can change the grid matrix[A[i].x][A[i].y] from sea to island.
 * Return how many island are there in the matrix after each operator.
 *
 *
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */



public class NumberOfIslandsII {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        if (n < 0 || m < 0 || operators == null ||operators.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        int numb;
        for (int i = 0; i < operators.length; i++) {
            if (isAdjacentIsland(operators[i])) {

            }
        }

        return resultList;
    }

    private boolean isAdjacentIsland(Point operator) {
        return false;
    }

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
