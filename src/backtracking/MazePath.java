import java.util.Arrays;
public class MazePath {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];

        allPathsPrint("", maze, 0, 0, path, 1);
    }

    static void allPathsPrint(String p, boolean[][] maze, int r, int c,
                              int[][] path, int step) {

        //  base condition
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;

            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();

            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // mark
        maze[r][c] = false;
        path[r][c] = step;

        // Down
        if (r < maze.length - 1) {
            allPathsPrint(p + "D", maze, r + 1, c, path, step + 1);
        }

        // Right
        if (c < maze[0].length - 1) {
            allPathsPrint(p + "R", maze, r, c + 1, path, step + 1);
        }

        // Up
        if (r > 0) {
            allPathsPrint(p + "U", maze, r - 1, c, path, step + 1);
        }

        // Left
        if (c > 0) {
            allPathsPrint(p + "L", maze, r, c - 1, path, step + 1);
        }

        //  BACKTRACK
        maze[r][c] = true;
        path[r][c] = 0;
    }
}