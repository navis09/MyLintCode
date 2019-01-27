package medium;


import java.util.*;

/**
 *
 * Implement a stack with min() function, which will return the smallest number in the stack.
 *
 * It should support push, pop and min operation all in O(1) cost.
 *
 * Example
 * push(1)
 * pop()   // return 1
 * push(2)
 * push(3)
 * min()   // return 2
 * push(1)
 * min()   // return 1
 *
 */
public class MinStack {

    private static Stack<Integer> stack = new Stack<>();;
    private static Stack<Integer> miniStack = new Stack<>();;

    /*
     * @param number: An integer
     * @return: nothing
     */
    public static void push(int number) {
        // write your code here
        stack.push(number);
        if (miniStack.isEmpty()) {
            miniStack.push(number);
        } else {
            miniStack.push(Math.min(number, miniStack.peek()));
        }

    }

    /*
     * @return: An integer
     */
    public static int pop() {
        // write your code here
        miniStack.pop();
        System.out.println(stack.peek());
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public static int min() {
        // write your code here
        System.out.println(miniStack.peek());
        return miniStack.peek();
    }


    /**
     * Expected
     * [23,23,24,19,19,28,28,19,19,25,25,26,25,25,20,20,26,21,26,26,21,25,23,21,21,21,21,27,19,19,27,27,27,28,28,21,21,27,27,22,29,29,21,24,24,24,29,29,23,20,20,24,24,24,20,20,24,24,24,24,29,24,24,24,24,24,22,25,25,21,21,27,27,28,28,25,27,24,27,27,25,23,23,25,21,21,21,23,21,22,21,21,25,25,25,25,25,26,26,26,26,25,25,25,27,25,26,27,23,23,20,29,29,24,24,26,26,26,26,26]
     * @param args
     */
    public static void main(String[] args) {

        push(23);
        min();
        pop();
        push(24);
        pop();
        push(19);
        min();
        pop();
        push(28);
        min();
        pop();
        push(19);
        min();
        pop();
        push(25);
        min();
        push(26);
        min();
        pop();
        min();
        pop();
        push(20);
        min();
        pop();
        push(26);
        min();
        push(21);
        pop();
        min();
        pop();
        push(21);
        pop();
        push(25);
        pop();
        push(23);
        pop();
        push(21);
        min();
        pop();
        push(21);
        min();
        pop();
        push(27);
        min();
        push(19);
        min();
        pop();
        min();
        pop();
        push(27);
        pop();
        push(28);
        min();
        pop();
        push(21);
        min();
        pop();
        push(27);
        min();
        pop();
        push(22);
        pop();
        push(29);
        min();
        pop();
        push(21);
        pop();
        push(24);
        pop();
        push(24);
        pop();
        push(24);
        pop();
        push(29);
        min();
        pop();
        push(23);
        pop();
        push(20);
        min();
        pop();
        push(24);
        min();
        pop();
        push(24);
        min();
        push(20);
        min();
        pop();
        min();
        push(24);
        min();
        push(24);
        min();
        push(29);
        min();
        pop();
        min();
        pop();
        min();
        pop();
        pop();
        push(22);
        pop();
        push(25);
        min();
        pop();
        push(21);
        min();
        pop();
        push(27);
        min();
        pop();
        push(28);
        min();
        pop();
        push(25);
        pop();
        push(27);
        min();
        push(24);
        pop();
        min();
        pop();
        push(25);
        min();
        push(23);
        min();
        pop();
        min();
        push(21);
        min();
        push(22);
        min();
        push(23);
        min();
        pop();
        min();
        pop();
        min();
        pop();
        min();
        push(25);
        min();
        pop();
        min();
        pop();
        push(26);
        min();
        pop();
        push(26);
        min();
        pop();
        push(25);
        min();
        pop();
        push(25);
        pop();
        push(27);
        pop();
        push(25);
        pop();
        push(26);
        pop();
        push(27);
        pop();
        push(23);
        min();
        pop();
        push(20);
        pop();
        push(29);
        min();
        pop();
        push(24);
        min();
        pop();
        push(26);
        min();
        pop();
        push(26);
        min();
        pop();
        push(26);
        min();
        push(29);


    }






}
