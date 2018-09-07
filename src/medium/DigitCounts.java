package medium;

/**
 * Count the number of k's between 0 and n. k can be 0 - 9.
 */
public class DigitCounts {

    public int digitCounts(int k, int n) {
        // write your code here
        if (k > n) {
            return -1;
        }
        int count = 0;
        String strK = String.valueOf(k);
        for (int i = 0; i <= n; i++) {
            String strI = String.valueOf(i);
            if (strI.indexOf(strK) > -1) {
                for (int j = 0; j < strI.length(); j++) {
                    if (String.valueOf(strI.charAt(j)).equals(strK)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DigitCounts().digitCounts(1,12));
        System.out.println("1".equals(String.valueOf('1')));
    }
}
