package medium;


import java.util.Stack;

/**
 *
 * There is now a railroad track. The n train carriages are arranged on the right side of the transfer station.
 * From 1 to n, they need to use the transfer station to move to the rails on the left side of the transfer station and
 * combine them into a train. However, due to customer requirements, these train carriages may need to be rearranged.
 * Your task is to determine whether this arrangement is legal.
 * If it is legal, return the number of train carriages in this transfer station with the largest number of train carriages.
 * If it is not legal, return -1.
 * You can think of this transfer station as a stack.
 * Each car can only enter the transfer station at most once, and the cars leaving from the transfer station can only go to
 * the left rail.
 *
 * Example
 * Given arr=[4,5,3,2,1], return 3.
 *
 * 1 Enter the transfer station,
 * 2 Enter the transfer station,
 * 3 Enter the transfer station,
 * 4 directly to the railroad on the left,
 * 5 directly to the railroad on the left,
 * 3 from the transfer station to the railroad on the left,
 * 2 from the transfer station to the railroad on the left,
 * 1 from the transfer station to the railroad on the left,
 * Therefore, [4, 5, 3, 2, 1] is legal, and the number of transfer stations which is the maximum is 3.
 *
 */
public class TrainCompartment {

    /**
     * @param arr: the arr
     * @return:  the number of train carriages in this transfer station with the largest number of train carriages
     */
    public int trainCompartmentProblem(int[] arr) {
        // Write your code here.
        if (arr.length <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int value = 1;
        int max = 0;
        while (index < arr.length) {
            while (value <= arr.length && value != arr[index] && (stack.isEmpty() || stack.peek() != arr[index])) {
                stack.push(value);
                value++;
            }
            if (value == arr[index]) {
                value++;
                index++;
                continue;
            }
            if (arr[index] == stack.peek()) {
                if (max < stack.size()) {
                    max = stack.size();
                }
                stack.pop();
                index++;
                continue;
            }
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new TrainCompartment().trainCompartmentProblem(new int[]{1,2,5,3,4}));
        System.out.println(new TrainCompartment().trainCompartmentProblem(new int[]{1,3,2,4,7,6,8,5}));
    }

}
