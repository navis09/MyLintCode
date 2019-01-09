package medium;


/**
 * Give n integers and an integer k, you can choose k integers in the n integers and add them up, now let you calculate how many ways that the sum of the k integers is a prime number.
 *
 * Example
 * Give a=[3,7,12,19], k=3, return 1
 *
 * Explanation:
 * There are 4 ways
 * 3＋7＋12=22　　3＋7＋19＝29　　7＋12＋19＝38　　3＋12＋19＝34, and only 29 is a prime.
 */
public class CombinationAndJudgementPrimeNumber {


    int ways = 0;

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8};
        int num = new CombinationAndJudgementPrimeNumber().getWays(arr, 3);
        System.out.println("\nThe count of prime number is: " + num);
    }

    public int getWays(int[] a, int k) {
        if (a == null || a.length == 0 || k == 0) {
            return ways;
        }
        int low = 0;
        int high = a.length;
        findWaysHelper(a, k, 0, low, high);

        return ways;
    }

    /**
     *
     *
     * Example: A middle state
     * array: {1,2,3,4,5,6,7,8}, 2 and 3 been calculted
     * k : 1
     * total : 5
     * low : 3 (value: 4)
     * high: 7 (value: 8)
     * Then iterate from index 3 to 7, like 234,235,236,237,238 and decide if the total value is prime.
     *
     *
     * @param a The array
     * @param k The count left to be calculated
     * @param total The total value of numbers that have been calculated.
     * @param low The start index
     * @param high The end index
     */
    private void findWaysHelper(int[] a, int k, int total, int low, int high) {

        if (k == 0) {
            if (isPrime(total)) {
                ways++;
                System.out.println(total + " -> Prime Number");
            } else {
                System.out.print(total + "\t");
            }
        }

        for (int i = low; i < high; i++) {
            findWaysHelper(a, k - 1, total + a[i], i + 1, high);
        }

    }

    private boolean isPrime(int total) {
        if (total <= 1) {
            return false;
        }
        if (total == 2 || total == 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                return false;
            }
        }
        return true;
    }

}
