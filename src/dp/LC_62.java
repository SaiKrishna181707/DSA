package dp;

import java.util.*;

public class LC_62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(uniquePaths(m,n));
    }
    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, m, n, dp);
    }

    static int helper(int row, int col, int m, int n, int[][] dp) {

        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int count = 0;
        if (row < m - 1) {
            count += helper(row + 1, col, m, n, dp);
        }
        if (col < n - 1) {
            count += helper(row, col + 1, m, n, dp);
        }
        dp[row][col] = count;
        return dp[row][col];
    }
}