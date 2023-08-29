package org.zhy.dynamicprogramming;

/**
 * 115. 不同的子序列
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
 * 题目数据保证答案符合 32 位带符号整数范围。
 */
public class LeetCode115 {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
