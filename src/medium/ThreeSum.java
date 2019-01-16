package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 *
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,0,-1,-1,-1,-1,0,1,1,1};

        System.out.println(new ThreeSum().threeSum(numbers));
        System.out.println(new ThreeSum().threeSum2(numbers));
    }

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     *
     * O(n^3)
     *
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        if (numbers.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(numbers);
        if (numbers[0] > 0 || numbers[numbers.length - 1] < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        int a = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] == a) {
                continue;
            } else {
                a = numbers[i];
            }
            int b = Integer.MIN_VALUE;
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (numbers[j] == b) {
                    continue;
                } else {
                    b = numbers[j];
                }
                int c = Integer.MIN_VALUE;
                for (int k = j + 1; k < numbers.length; k++) {
                    if (a + b + numbers[k] != 0 || numbers[k] == c) {
                        continue;
                    } else {
                        c = numbers[k];
                        List<Integer> subList = new ArrayList<>();
                        subList.add(a);
                        subList.add(b);
                        subList.add(c);
                        list.add(subList);
                    }
                }
            }

        }

        return list;

    }


    /**
     * O(n ^ 2) time complexity
     * @param numbers
     * @return
     */
    public List<List<Integer>> threeSum2(int[] numbers) {
        // write your code here
        if (numbers.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(numbers);
        if (numbers[0] > 0 || numbers[numbers.length - 1] < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int sum = -numbers[i];

            twoSum(numbers, sum, i + 1, numbers.length - 1, list);
        }

        return list;

    }

    private void twoSum(int[] numbers, int sum, int left, int right, List<List<Integer>> list) {
        while (left < right) {
            if (numbers[left] + numbers[right] == sum) {
                List<Integer> subList = new ArrayList<>();
                subList.add(-sum);
                subList.add(numbers[left]);
                subList.add(numbers[right]);
                list.add(subList);
                left++;
                right--;

                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (numbers[left] + numbers[right] < sum) {
                left++;
            } else {
                right--;
            }

        }

    }

}
