package org.zhy.dynamicprogramming;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 参考LeetCode123,将两次变为多次，
        // dp数组可以为int[n][2 * k],即从[n][0]到[n][2k-1]中时i次买和i次卖循环最大收益
        // 也可以为int[n][k][2]，即[n][i][0]是i次买的最大收益，[n][i][1]是i次卖最大收益
        int[][] dp = new int[n][2 * k];
        // dp[i][0] 为第 i 天的买入一次的最大利润
        dp[0][0] = -prices[0];
        for (int i = 1; i < 2 * k; i++) {
            dp[0][i] = Integer.MIN_VALUE / 2;
        }
        int flag = 1;
        for (int i = 1; i < n; i++) {
            // 如果第 i 天的状态是买入一次，则可能在第 i 天之前买入或在第 i 天买入，
            // 此时的最大利润是 max(dp[i - 1][0], -prices[i])
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            flag = 1;

            for (int j = 1; j < 2 * k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + (flag * prices[i]));
                flag *= -1;
            }
        }
        int max = 0;
        // 只判断卖出时最大收益和不买股票的收益
        for (int i = 1; i < 2 * k; i += 2) {
            max = Math.max(max,dp[n-1][i]);
        }
        return max;
    }
}
