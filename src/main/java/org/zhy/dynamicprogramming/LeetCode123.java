package org.zhy.dynamicprogramming;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 每天的状态包括五种情况：无操作、买入一次、卖出一次、买入两次、卖出两次。
        // 其中，无操作对应的利润一定是 0，因此只需要考虑其余四种情况的利润。
        int[][] dp = new int[n][4];
        // dp[i][0] 为第 i 天的买入一次的最大利润
        dp[0][0] = -prices[0];
        // dp[i][1] 为第 i 天的卖出一次的最大利润
        dp[0][1] = Integer.MIN_VALUE / 2;
        // dp[i][2] 为第 i 天的买入两次的最大利润
        dp[0][2] = Integer.MIN_VALUE / 2;
        // dp[i][3] 为第 i 天的卖出两次的最大利润
        dp[0][3] = Integer.MIN_VALUE / 2;
        for (int i = 1; i < n; i++) {
            // 如果第 i 天的状态是买入一次，则可能在第 i 天之前买入或在第 i 天买入，
            // 此时的最大利润是 max(dp[i - 1][0], -prices[i])
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 如果第 i 天的状态是卖出一次，则可能在第 i 天之前卖出或在第 i 天卖出，卖出之前已经买入一次，
            // 此时的最大利润是 max(dp[i - 1][1], dp[i - 1][0] + prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            // 同理，如果第 i 天的状态是买入两次，最大利润是 max(dp[i - 1][2], dp[i - 1][1] - prices[i])
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            // 同理，如果第 i 天的状态是卖出两次，最大利润是 max(dp[i - 1][3], dp[i - 1][2] + prices[i])
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        // dp[i][0]和dp[i][2]为持有状态，求最大收益肯定要在卖出状态求，所以只判断dp[i][1]和dp[i][3]
        // 也有可能买卖股票都是负收益，比如 {5，4，3，2，1}，所以要和0（都没买）判断大小
        return Math.max(0, Math.max(dp[n - 1][1], dp[n - 1][3]));
    }
}
