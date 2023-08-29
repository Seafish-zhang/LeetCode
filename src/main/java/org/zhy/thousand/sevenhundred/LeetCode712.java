package org.zhy.thousand.sevenhundred;

/**
 * 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 */
public class LeetCode712 {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // base case
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int c1 = s1.charAt(i - 1);
                int c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    // 相等情况
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不等情况
                    dp[i][j] = Math.min(dp[i][j - 1] + c2, dp[i - 1][j] + c1);
                }
            }
        }
        return dp[n1][n2];
    }
}
