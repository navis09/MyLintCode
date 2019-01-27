package easy;


import java.util.Stack;

/**
 * On the Qixi Festival, the Cowherd and the Weaver play together in a maze size of n*m . However, they get separated from each other.
 * Now given the maze consisting of .,*,S,T, where . denotes an empty space, * denotes an obstacle,
 * S denotes the position of the cowherd, T denotes the position of the weaver,
 * the Cowherd and the Weaver will try to find each other(they can move to the grid up or down or left or right or stand still,
 * but they can't walk outside of the maze or move to obstacles).
 *
 * Is it possible for them reunion? If possible, return True, otherwise return False.
 */
public class CowherdNWeaver {

    int startX;
    int startY;
    int endX;
    int endY;

    boolean[][] isViewed;
    int[][] isAllowed;

    public static void main(String[] args) {
        String[] maze = new String[]{
                "....*",
                ".....",
                ".....",
                "*S**.",
                "T.*.*"};
        String[] maze1 = new String[]{
                "S..*",
                "*.**",
                "...T"};
        String[] maze2 = new String[]{
                ".***.",
                "**T..",
                "..S*.",
                ".....",
                "....."};
        String[] maze3 = new String[]{
                ".***.",
                "**T..",
                "..***",
                "...S.",
                "....."};

        System.out.println(new CowherdNWeaver().findHer(maze));
        System.out.println(new CowherdNWeaver().findHer(maze1));
        System.out.println(new CowherdNWeaver().findHer(maze2));
        System.out.println(new CowherdNWeaver().findHer(maze3));

        System.out.println(new CowherdNWeaver().findHer2(maze));
        System.out.println(new CowherdNWeaver().findHer2(maze1));
        System.out.println(new CowherdNWeaver().findHer2(maze2));
        System.out.println(new CowherdNWeaver().findHer2(maze3));
    }

    /**
     * Stack:
     *
     * @param maze: the maze
     * @return: Can they reunion?
     */
    public boolean findHer2(String[] maze) {
        // Write your code here
        if (maze.length == 0) {
            return false;
        }
        int row = maze.length;
        int column = maze[0].length();

        isViewed = new boolean[row][column];

        convertTo2DArray(maze);

        return canGoByStack(isAllowed, endX, endY);

    }


    private boolean canGoByStack (int[][] isAllowed, int yStart, int yEnd) {

        int row = isAllowed.length;
        int column = isAllowed[0].length;
        Stack<Position> stack = new Stack<>();

        stack.push(new Position(yStart, yEnd));
        while (!stack.isEmpty()) {

            Position position = stack.pop();
            if (position.x == startX && position.y == startY) {
                return true;
            }
            if (position.x < 0 || position.x >= row) {
                continue;
            }
            if (position.y < 0 || position.y >= column) {
                continue;
            }
            if (isViewed[position.x][position.y]) {
                continue;
            }
            isViewed[position.x][position.y] = true;
            if (isAllowed[position.x][position.y] == 0) {
                continue;
            }
            stack.push(new Position(position.x - 1, position.y));
            stack.push(new Position(position.x + 1, position.y));
            stack.push(new Position(position.x, position.y - 1));
            stack.push(new Position(position.x, position.y + 1));

        }
        return false;
    }

    /**
     * Recursive:
     * StackOverFlow problem for big maze
     *
     * @param maze: the maze
     * @return: Can they reunion?
     */
    public boolean findHer(String[] maze) {
        // Write your code here
        if (maze.length == 0) {
            return false;
        }
        int row = maze.length;
        int column = maze[0].length();

        isViewed = new boolean[row][column];

        convertTo2DArray(maze);

        return canGo(isAllowed, endX, endY);

    }

    private void convertTo2DArray(String[] maze) {

        isAllowed = new int[maze.length][maze[0].length()];
        for (int i = 0; i < maze.length; i++) {
            String s = maze[i];
            for (int j = 0; j < maze[0].length(); j++) {
                if (s.charAt(j) == 'S') {
                    isAllowed[i][j] = 2;
                    startX = i;
                    startY = j;
                } else if (s.charAt(j) == 'T') {
                    isAllowed[i][j] = 2;
                    endX = i;
                    endY = j;
                } else if (s.charAt(j) == '.') {
                    isAllowed[i][j] = 1;
                } else {
                    isAllowed[i][j] = 0;
                }

            }
        }
    }

    private boolean canGo (int[][] isAllowed, int i, int j) {
        if (i < 0 || i >= isAllowed.length) {
            return false;
        }
        if (j < 0 || j >= isAllowed[0].length) {
            return false;
        }
        if (isViewed[i][j]) {
            return false;
        }

        if (isAllowed[i][j] == 0) {
            return false;
        }
        if (isAllowed[i][j] == 2 && (i != endX || j != endY)) {
            return true;
        }
        isViewed[i][j] = true;

        return canGo(isAllowed, i - 1, j) || canGo(isAllowed, i + 1, j) || canGo(isAllowed, i, j - 1) || canGo(isAllowed, i, j + 1);
    }

}

class Position {
    int x;
    int y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}