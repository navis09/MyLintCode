package medium;


import java.util.Arrays;

/**
 *
 * For n people, each of them needs to do m jobs independently.
 * The i job takes cost[i] time. Since each person's free time is different, the i person has val[i] time, which
 * means that the total time for his jobs will not exceed val[i].
 * Everyone starts with the first job, then the 2nd, the 3rd...
 * Now, you need to figure out how much time they spend.
 *
 */
public class DoingHomework {

    /**
     * @param cost: the cost
     * @param val: the val
     * @return: the all cost
     */
    public static long doingHomework(int[] cost, int[] val) {
        long[] totalCost = new long[cost.length];
        totalCost[0] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            totalCost[i] = totalCost[i - 1] + cost[i];
        }
        long totalTime = 0;

        Arrays.sort(val);
        int costIndex = 0;
        int valIndex = 0;
        while (valIndex < val.length) {
            if (costIndex == 0 && val[valIndex] < totalCost[costIndex]) {
                valIndex++;
                continue;
            }
            while(costIndex < totalCost.length && val[valIndex] >= totalCost[costIndex]) {
                costIndex++;
            }
            totalTime += totalCost[costIndex - 1];
            valIndex++;
        }

//        for (int i = 0; i < val.length; i++) {
//            long timeSpent = 0;
//            for (int j = totalCost.length - 1; j >= 0; j--) {
//                if (val[i] >= totalCost[j]) {
//                    timeSpent = totalCost[j];
//                    totalTime += timeSpent;
//                    break;
//                }
//            }
//        }
        return totalTime;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{5,7,1,5,10,3,7,1};
        int[] val = new int[]{11,5,40,41,2,17,32,1,1,6};

        System.out.println(doingHomework(cost, val));

    }
}
