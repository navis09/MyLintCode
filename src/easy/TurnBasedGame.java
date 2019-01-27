package easy;

import java.util.Arrays;


/**
 * QW is a player of a turn-based game, and today he decided to kill monsters.
 *
 * QW will fight with n monsters in a battle. Each monster has an attack power atk[i]. If the i-th monster is still alive at the end of each round, it will cause atk[i] damage to the QW. QW can only kill one monster at the beginning of each round. Please calculate how much damage he needs to suffer at least after QW kill all the monsters.
 *
 * Example
 * Givenatk=[1,3,2,5],return10
 *
 * Givenatk=[1,1,1,1,1,1],return15
 */
public class TurnBasedGame {
    /**
     * @param atk: the atk of monsters
     * @return: Output the minimal damage QW will suffer
     */
    public long getAns(int[] atk) {
        // Write your code here

        if (atk.length <= 1) {
            return 0L;
        }
        long sum = 0;
        Arrays.sort(atk);

        for (int i = atk.length - 2; i >= 0; i--) {
            long sub = atk[i];
            sum += (long)(sub * (atk.length - i - 1));
        }
        return sum;
    }

}
