package others;

import java.util.concurrent.ArrayBlockingQueue;

public class ConcurrentTest {


    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + ": " + arrayBlockingQueue.peek());
        }).start();

        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);
        arrayBlockingQueue.offer(3);
        arrayBlockingQueue.offer(4);
        arrayBlockingQueue.poll();
        arrayBlockingQueue.offer(5);
        arrayBlockingQueue.offer(6);
        arrayBlockingQueue.offer(7);
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.offer(8);
        arrayBlockingQueue.offer(9);
        arrayBlockingQueue.offer(10);

        while (!arrayBlockingQueue.isEmpty()) {
            System.out.println(arrayBlockingQueue.poll());
        }

    }
}
