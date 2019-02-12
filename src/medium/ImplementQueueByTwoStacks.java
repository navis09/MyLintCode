package medium;


import java.util.Stack;

/**
 *
 * As the title described, you should only use two stacks to implement a queue's actions.
 *
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 *
 * Both pop and top methods should return the value of first element.
 *
 * Example
 * push(1)
 * pop()     // return 1
 * push(2)
 * push(3)
 * top()     // return 2
 * pop()     // return 2
 *
 */
public class ImplementQueueByTwoStacks {

    private Stack<Integer> readStack;
    private Stack<Integer> writeStack;

    public ImplementQueueByTwoStacks() {
        // do intialization if necessary
        readStack = new Stack<>();
        writeStack = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        if (readStack.isEmpty()) {
            readStack.push(element);
        } else {
            while (!readStack.isEmpty()) {
                writeStack.push(readStack.pop());
            }
            writeStack.push(element);
            while(!writeStack.isEmpty()) {
                readStack.push(writeStack.pop());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        return readStack.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return readStack.peek();
    }

    public static void main(String[] args) {
        ImplementQueueByTwoStacks queue = new ImplementQueueByTwoStacks();
        queue.push(1);
        queue.pop();
        queue.push(2);
        queue.push(3);
        queue.top();
        queue.pop();
    }

}
