package medium;

/**
 * Dynamic Programming
 *
 * Buy 199 get 99 off
 * To find the best selection
 *
 */
public class TBShopping {


    /**
     *
     * @param prices Price of each snack
     * @param n Total number
     * @param w The condition of discount
     */
    public static void shoppingSnacks(int[] prices, int n, int w) {

        // triple the condition
        boolean[][] tree = new boolean[n][3*w+1];
        tree[0][0] = true;
        tree[0][prices[0]] = true;

        // DP
        for (int i = 1; i < n; i++) {

            // ignore the current
            for (int j = 0; j <= 3*w; j++) {
                if (tree[i - 1][j]) {
                    tree[i][j] = true;
                }
            }

            // buy the current
            for (int j = 0; j <= 3*w-prices[i]; j++) {
                if (tree[i - 1][j]) {
                    tree[i][j + prices[i]] = true;
                }
            }
        }

        // find the closest condition
        int j;
        for (j = w; j < 3*w+1; j++) {
            if (tree[n - 1][j]) {
                System.out.println("The total price of the closest condition is : " + (float)j/10);
                break;
            }
        }

        // no selection
        if (j == -1) {
            return;
        }

        System.out.println("You should buy: ");
        // iterate from the end
        for (int i = n - 1; i > 0; i--) {
            // The price of current bill should be larger than the snack
            // And the state should be true
            if (j - prices[i] >= 0 && tree[i - 1][j - prices[i]] == true) {
                System.out.println(i + ": " + (float)prices[i]/10);
                j = j - prices[i];
            } else {
                // no
            }
        }
        if (j != 0) {
            System.out.println(0 + ": " + (float)prices[0]/10);
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{269, 249, 499, 289, 149, 169, 199, 190, 149, 149, 269};
        shoppingSnacks(prices, prices.length, 1990);
    }

}
