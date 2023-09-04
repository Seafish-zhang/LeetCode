package org.zhy.dynamicprogramming;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[][] dp = new int[n][3];
        // 不持股且当天没卖出,定义其最大收益dp[i][0]
        dp[0][0] = 0;
        // 持股,定义其最大收益dp[i][1]
        dp[0][1] = -1 * prices[0];
        // 不持股且当天卖出了，定义其最大收益dp[i][2]；
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];

        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}
