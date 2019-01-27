package medium;


/**
 *
 * n people are playing games, each game has a referee and n-1 players.
 * The A array means that everyone wants to be at least Ai (0 <= i < n) times.
 * Please find the minimum number of games to play.
 *
 * Example
 * input:A=[2,2,2,2]
 * output:ans=3
 *
 */
public class PlayGame {

    /**
     * @param A:
     * @return: nothing
     */
    public long playGames(int[] A) {
        // Write your code here
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }

        long times = 0;
        long total = 0;
        long max = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            if (A[i] > max) {
                max = A[i];
            }
        }

        if (total % (A.length - 1) == 0) {
            times = total / (A.length - 1);
        } else {
            times =  total / (A.length - 1) + 1;
        }

        return times > max ? times : max;
    }

    public static void main(String[] args) {
        System.out.println(new PlayGame().playGames(new int[]{39,22,89,54,91,5,30}));
    }

}
