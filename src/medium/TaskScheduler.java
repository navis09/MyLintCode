package medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example
 * Given tasks = ['A','A','A','B','B','B'], n = 2, return 8.
 *
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 */
public class TaskScheduler {

    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        // calculate the occurance
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }
        // find the largest occurance
        int max = 0;
        // find the number of characters that equals the occurance
        int num = 1;
        // For example : AAABBBCCDD
        // 'A' and 'B' both occur 3 times, so max is 3 and num is 2.
        // The pattern is like ABXABXAB
        for (Integer i : map.values()) {
            if (max < i) {
                max = i;
                num = 1;
            } else if (max == i) {
                num++;
            }
        }

        int interval = (max - 1) * (n + 1) + num;
        return interval < tasks.length ? tasks.length : interval;
    }

}
