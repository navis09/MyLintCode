package easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given n students(number from 1 to n) and their examination grades. There are two keywords, examination grades and student id. Order the array
 * according to the second keyword (Descending), if the first key is the same, it is sorted by the first keyword (ascending).
 *
 * Example
 * Given [[2,50],[1,50],[3,100]],
 * return [[3,100],[1,50],[2,50]]
 *
 */
public class MultikeywordSort {

    public int[][] multiSort(int[][] array) {
        // Write your code here
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(new Node(array[i][0], array[i][1]));
        }
        Collections.sort(list);
        int[][] arr = new int[array.length][2];
        for (int i = 0; i < array.length; i++) {
            arr[i][0] = list.get(i).id;
            arr[i][1] = list.get(i).score;
        }
        return arr;
    }

    class Node implements Comparable<Node>{
        int id;
        int score;
        public Node(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Node node) {
            if (this.score == node.score) {
                return this.id - node.id;
            }
            return node.score - this.score;
        }
    }



}
