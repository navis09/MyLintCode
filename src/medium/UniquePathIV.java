package medium;


/**
 * Give two integers to represent the height and width of the grid.
 * The starting point is in the upper left corner and the ending point is in the upper right corner.
 * You can go to the top right, right or bottom right.
 * Find out the number of paths you can reach the end. And the result needs to mod 1000000007.
 */
public class UniquePathIV {

    /**
     * @param height: the given height
     * @param width: the given width
     * @return: the number of paths you can reach the end
     */
    public int uniquePath(int height, int width) {

        long[][] grid = new long[width][height];
        //init
        for (int row = 0; row < height - 1; row++) {
            grid[0][row] = 0L;
        }
        grid[0][height - 1] = 1L;

        //iterate
        for (int column = 1; column < width; column++) {
            grid[column][0] = grid[column - 1][0] + grid[column - 1][1];
            grid[column][height - 1] = grid[column - 1][height - 1] + grid[column - 1][height - 2];
            for (int row = 1; row < height - 1; row++) {
                grid[column][row] = grid[column - 1][row] + grid[column - 1][row - 1] + grid[column - 1][row + 1];
                grid[column][row] = grid[column][row] % 1000000007;
            }
        }

        return (int) (grid[width - 1][height - 1] % 1000000007);

    }

    public static void main(String[] args) {
        System.out.println(new UniquePathIV().uniquePath(40, 46));
    }

}
