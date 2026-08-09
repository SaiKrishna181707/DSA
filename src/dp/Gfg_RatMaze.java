package dp;

import java.util.*;

public class Gfg_RatMaze {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] maze = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = in.nextInt();
            }
        }
        ArrayList<String> result = new ArrayList<>();

        helper(result, maze, 0, 0, "");
        Collections.sort(result);

        for (String path : result) {
            System.out.println(path);
        }
    }

    static void helper(ArrayList<String> result,
                       int[][] maze,
                       int row,
                       int col,
                       String p) {

        if (maze[row][col] == 0) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            result.add(p);
            return;
        }

        maze[row][col] = 0;

        if (row < maze.length - 1) {
            helper(result, maze, row + 1, col, p + "D");
        }
        if (col < maze[0].length - 1) {
            helper(result, maze, row, col + 1, p + "R");
        }
        if (col > 0) {
            helper(result, maze, row, col - 1, p + "L");
        }
        if (row > 0) {
            helper(result, maze, row - 1, col, p + "U");
        }
        maze[row][col] = 1;
    }
}
