package dp;

import java.util.*;

class LC70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = climbStair(n);
        System.out.println(ans);
    }

    static int climbStair(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    static int helper(int n, int[] dp) {

        if (n <= 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
}

