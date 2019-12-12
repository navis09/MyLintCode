package easy;

/**
 * CountPrimes
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * @author jinxin
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        int[] arr = new int[n + 1];
        arr[2] = 0;
        arr[3] = 1;
        arr[4] = 2;
        for (int i = 5; i <= n; i++) {
            if (i % 2 == 1 || i % 3 == 1) {
                arr[i] = arr[i - 1];
                continue;
            }
            int sqrt = (int) Math.sqrt(i);
            for (int j = 2; j <= sqrt; j++) {
                if ((i - 1) % j == 0) {
                    arr[i] = arr[i - 1];
                    break;
                }
                if (j == sqrt) {
                    arr[i] = arr[i - 1] + 1;
                }
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int oldCapacity = 15;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
        System.out.println(new CountPrimes().countPrimes(10));
    }
}
