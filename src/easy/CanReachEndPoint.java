package easy;


/**
 *
 * Given a map size of m*n, 1 means space, 0 means obstacle, 9 means the endpoint.
 * You start at (0,0) and return whether you can reach the endpoint.
 *
 * Example
 * Input:[[1,1,1],[1,1,1],[1,1,9]]
 * Output:true
 *
 */
public class CanReachEndPoint {


    boolean isVisit[][];
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        if (map.length == 0 || map[0].length == 0) {
            return false;
        }
        isVisit = new boolean[map.length][map[0].length];
        int m = -1;
        int n = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 9) {
                    m = i;
                    n = j;
                }
            }
        }
        return canReach(map, m, n);
    }

    private boolean canReach(int[][] map, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return false;
        }

        if (isVisit[x][y]) {
            return false;
        }
        if (map[x][y] == 0) {
            return false;
        }
        if (x == 0 && y == 0) {
            return true;
        }
        isVisit[x][y] = true;
        return canReach(map, x - 1, y) || canReach(map, x + 1, y) || canReach(map, x, y - 1) || canReach(map, x, y + 1);
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        arr[0] = new int[]{1,1,1,1,0,1};
        arr[1] = new int[]{0,1,0,0,0,0};
        arr[2] = new int[]{1,0,0,0,1,0};
        arr[3] = new int[]{0,0,1,1,1,0};
        arr[4] = new int[]{1,1,0,0,0,0};
        arr[5] = new int[]{1,9,1,1,0,0};
        System.out.println(new CanReachEndPoint().reachEndpoint(arr));
    }

}
